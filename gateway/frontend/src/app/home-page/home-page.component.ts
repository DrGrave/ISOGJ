import {Component, OnInit, ViewChild} from '@angular/core';
import {HomePageService} from './home-page.service';
import {FormBuilder, FormControl, FormControlName, FormGroup, NgModel, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {MatDatepickerInputEvent, MatPaginator} from "@angular/material";
import {FullUserInfo} from "./FullUserInfo";
import {Gender} from "./Gender";
import {City} from "./City";
import {Observable} from "rxjs/Observable";
import {map, startWith} from "rxjs/operators";
import {TypeOfEducation} from "./TypeOfEducation";
import {University} from "./University";
import {Faculty} from "./Faculty";
import {Department} from "./Department";
import {Education} from "./Education";






@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  newEducation: Education;


  ifOk: true;

  cityList: City[];
  universityList: University[];
  facultyList: Faculty[];
  departmentList: Department[];

  universityCtrl: FormControl;
  cityCtrl: FormControl;
  facultyCtrl: FormControl;
  departmentCtrl: FormControl;

  reactiveFaculty: any;
  reactiveUniversity: any;
  reactiveCity: any;
  reactiveDepartment: any;

  universitys: University[];
  citys: City[];
  facultys: Faculty[];
  departments: Department[];

  changedDateOfStart: Date;
  changedDateOfEnd: Date;
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
  ifAddClick = true;


  selectedUniversity: University;
  selectedFaculty: Faculty;

  facultyOption: Faculty[];
  departmentOption: Department[];


  universityName: string;
  cityName: string;
  facultyName: string;
  departmentName: string;

  cityForm: FormGroup;
  universityForm: FormGroup;
  cityDesForm: FormGroup;


  typeOfEducation: TypeOfEducation[];
  selectedTypeOfEducation: TypeOfEducation;




  constructor(private homePageService: HomePageService, private router: Router, private fb: FormBuilder) {

    this.citys = [];
    this.universitys = [];
    this.facultys = [];
    this.departments = [];

    this.cityList = [];
    this.universityList = [];
    this.facultyList = [];
    this.departmentList = [];

    this.departmentCtrl = new FormControl({id: '', name: '', specialization: ''});
    this.reactiveDepartment = this.departmentCtrl.valueChanges
      .pipe(
        startWith(this.departmentCtrl.value),
        map( value => this.displayFn(value)),
        map(name => this.departmentFilter(name, this.departments))
      );

    this.facultyCtrl = new FormControl({id: '', name: ''});
    this.reactiveFaculty = this.facultyCtrl.valueChanges
      .pipe(
        startWith(this.facultyCtrl.value),
        map( value => this.displayFn(value)),
        map( name => this.facultyFilter(name, this.facultys))
      );


    this.universityCtrl = new FormControl({id:  '', name: ''});
    this.reactiveUniversity = this.universityCtrl.valueChanges
      .pipe(
        startWith(this.universityCtrl.value),
        map(val => this.displayFn(val)),
        map(name => this.universityFilter(name, this.universitys))
      );



    this.facultyOption = [];
    this.departmentOption = [];

  }



  displayFn(value: any): string {
    return value && typeof value === 'object' ? value.name : value;
  }

  departmentFilter(val: string, options: any[]){
    this.departmentName = val;
    this.selectedFaculty = this.facultyList.filter( item => item.name === this.facultyName)[0];
    options = this.getDepartment(val, this.selectedFaculty);
    return this.filter(val, options);
  }

  facultyFilter(val: string, options: any[]){
    this.facultyName = val;
    this.selectedUniversity = this.universityList.filter(item => item.name === this.universityName)[0];
    options = this.getFaculty(val, this.selectedUniversity);
    return this.filter(val, options);
  }

  cityFilter(val: string, options: any[]){
    options = this.getCity(val);
    this.cityName = val;
    return this.filter(val, options);
  }

  universityFilter(val: string, options: any[]){
    options = this.getUniversity(val);
    this.universityName = val;
    this.selectedUniversity = options.filter( item => item.name === this.universityName)[0];
    return this.filter(val, options);
  }

  filter(val: string, options: any[]) {
    return val ? this._filter(options, val) : this.citys;
  }


  private _filter(values: any[], val: string) {
    const filterValue = val.toLowerCase();
    return values.filter(date => date.name.toLowerCase().startsWith(filterValue));
  }


  ngOnInit() {

    this.getMyAccount();

    this.cityForm = this.fb.group({
      inputCity: new FormControl(
        { value: ''},
        {validators: [Validators.required]})
    });

    this.getNewEducation();


    this.cityDesForm = this.fb.group({
      inputCityDisable: new FormControl({value: '', disabled: true})
    });

    this.universityForm = this.fb.group({
      inputUniversity: new FormControl(
        {value: ''},
        {validators: [Validators.required]})
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
      localStorage.setItem('myUser', JSON.stringify(this.myUser));




      this.cityCtrl = new FormControl({id:  data.meUserDto.city.id, name: data.meUserDto.city.name, enabled: false});
      this.reactiveCity = this.cityCtrl.valueChanges
        .pipe(
          startWith(this.cityCtrl.value),
          map(val => this.displayFn(val)),
          map(name => this.cityFilter(name, this.citys))
        );
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


  private getCity(name: string): City[] {
    this.homePageService.getCity(name).subscribe(dat => this.cityList = dat);
    return this.cityList;
  }

  getUniversity(name): University[]{
    this.homePageService.getUniversity(name).subscribe( date => this.universityList = date);
    return this.universityList;
  }

  getFaculty(name: string, university: University): Faculty[]{
    this.homePageService.getFaculty(name, university).subscribe( facultyDate => {
      this.facultyList = facultyDate;
    });
    return this.facultyList;
  }

  getDepartment(name: string, faculty: Faculty): Department[]{
    this.homePageService.getDepartments(name, faculty).subscribe( departmentDate => {
      this.departmentList = departmentDate;
    });
    return this.departmentList;
  }

  applyCityChange() {
    if (this.cityName){
      if (this.cityName.toLocaleLowerCase().indexOf('undefined') === 0){

      }else {
        this.homePageService.changeCity(this.cityName).subscribe(date => {
          this.myUser.meUserDto.city = date;
        })
      }
    }
  }

  getNewEducation(){
    this.homePageService.getAllTypesOfEducation().subscribe( date => {
      this.typeOfEducation = date;
    });
  }

  applyAddEducation(){
    this.newEducation.department =  this.departmentList.filter( item => item.name === this.departmentName)[0];
    this.newEducation.dateOfStart = this.changedDateOfStart.getTime();
    this.newEducation.dateOfEnd = this.changedDateOfEnd.getTime();
    this.homePageService.addEducation(this.newEducation).subscribe(date => this.myUser.educationSkillsDtoList = date);
  }

  convertDate(dateOfEnd: number): String {
    return new Date(dateOfEnd).toISOString();
  }

  changeStartEvent(event: MatDatepickerInputEvent<Date>) {
    this.changedDateOfStart = event.value;
  }

  changeEndEvent(event: MatDatepickerInputEvent<Date>) {
    this.changedDateOfEnd = event.value;
  }
}


