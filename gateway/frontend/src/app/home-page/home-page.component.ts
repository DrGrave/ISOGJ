import {Component, OnInit, ViewChild} from '@angular/core';
import {HomePageService} from './home-page.service';
import {FormBuilder, FormControl, FormControlName, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {MatDatepickerInputEvent, MatPaginator} from "@angular/material";
import {FullUserInfo} from "./FullUserInfo";
import {Gender} from "./Gender";
import {City} from "./City";
import {Observable} from "rxjs/Observable";
import {map, startWith} from "rxjs/operators";
import {async} from "rxjs/scheduler/async";



@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  myUser: FullUserInfo;
  username: string;
  genders: Gender[];
  pageNum: number = 0;
  pageSiz: number = 0;
  historyCount: number = 0;
  ifChangeGenderClick: boolean = false;
  ifChangeCityClick: boolean = true;
  selectedGender;

  selectedCity: City;
  cityOption: City[];
  cityName: string;
  filteredCity: Observable<City[]>;
  cityControl = new FormControl();
  cityForm: FormGroup;
  cityDesForm: FormGroup;






  cityFilter(name: string): City[]{
    this.selectedCity = this.cityOption.filter(item => item.name === this.cityName)[0];
    this.getCity(name);
    this.cityName = name;
    return this.cityOption.filter(option => option.name.toLocaleLowerCase().indexOf(name.toLocaleLowerCase()) === 0);
  }

  displayCityFn(city?: City): string | undefined{
    return city ? city.name: undefined;
  }

  constructor(private homePageService: HomePageService, private router: Router, private fb: FormBuilder) {
    this.cityOption = [];

  }


  ngOnInit() {

    this.filteredCity = this.cityControl.valueChanges
            .pipe(
              startWith<string | City>(''),
              map(value => typeof value === 'string' ? value : value.name),
              map( name => name ? this.cityFilter(name) : this.cityOption.slice())
            );

    this.getMyAccount();

    this.cityForm = this.fb.group({
      inputCity: new FormControl(
        { value: ''},
        {validators: [Validators.required]})
    });

    this.cityDesForm = this.fb.group({
      inputCityDisable: new FormControl({value: '', disabled: true})
    })
  }

  getMyAccount(){
    this.homePageService.getSizeHistory().subscribe(date =>{
      this.historyCount = date;
    });
    this.homePageService.getUser().subscribe( data => {
      this.myUser = data;
      this.getGenders();
      this.selectedGender = data.meUserDto.gender;
      this.selectedCity = data.meUserDto.city;
      localStorage.setItem('myUser', JSON.stringify(this.myUser))
    });

  }

  getNextPage(event){
    this.pageNum = this.paginator.pageIndex;
    this.pageSiz = this.paginator.pageSize;
    this.getNextHistory(this.pageSiz, this.pageNum);
  }

  private getNextHistory(pageSiz: number, pageNum: number) {
    this.homePageService.getHistory(this.pageNum,this.pageSiz).subscribe(date => {
      this.myUser.historySkillsDtoList = date;
    });
  }

  private getGenders(){
    this.homePageService.getAllGenders().subscribe( date => {
      this.genders = date;
      this.selectedGender = this.myUser.meUserDto.gender.id;
    });
  }

  changeGenderAction() {

    this.ifChangeGenderClick = !this.ifChangeGenderClick;
    this.ifChangeCityClick = !this.ifChangeCityClick;
  }


  changeGenderApply() {
    this.ifChangeGenderClick = !this.ifChangeGenderClick;
    if (this.myUser.meUserDto.gender.id != this.selectedGender) {
      this.homePageService.changeGender(this.selectedGender).subscribe(date =>{
        this.myUser.meUserDto.gender = date;
      });
    }
  }


  private getCity(name: string) {
        this.homePageService.getCity(name).subscribe( date => this.cityOption = date);
  }

  applyCityChange() {
    if (this.cityName.toLocaleLowerCase().indexOf('undefined') === 0){

    }else {
      this.homePageService.changeCity(this.cityName).subscribe(date => {
        this.myUser.meUserDto.city = date;
        this.selectedCity = date;
      })
    }
  }
}


