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
import {TypeOfEducation} from "./TypeOfEducation";
import {University} from "./University";
import {Faculty} from "./Faculty";
import {Department} from "./Department";


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
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

  selectedCity: City;
  selectedUniversity: University;
  selectedFaculty: Faculty;
  selectedDepartment: Department;

  universityOption: University[];
  cityOption: City[];
  facultyOption: Faculty[];
  departmentOption: Department[];


  universityName: string;
  cityName: string;
  facultyName: string;
  departmentName: string;

  cityControl = new FormControl();
  universityControl = new FormControl();
  facultyControl = new FormControl();
  departmentControl = new FormControl();


  cityForm: FormGroup;
  universityForm: FormGroup;
  cityDesForm: FormGroup;


  typeOfEducation: TypeOfEducation[];
  selectedTypeOfEducation: TypeOfEducation;

  filteredCity: Observable<City[]>;
  filteredUniversity: Observable<University[]>;
  filteredFaculty: Observable<Faculty[]>;
  filteredDepartment: Observable<Department[]>;









  cityFilter(name: string): City[]{
    this.selectedCity = this.cityOption.filter(item => item.name === this.cityName)[0];
    this.getCity(name);
    this.cityName = name;
    return this.cityOption.filter(option => option.name.toLocaleLowerCase().indexOf(name.toLocaleLowerCase()) === 0);
  }

  universityFilter(name: string): University[]{
    this.selectedUniversity = this.universityOption.filter( item => item.name === this.universityName)[0];
    this.getUniversity(name);
    this.universityName = name;
    return this.universityOption.filter( option => option.name.toLocaleLowerCase().indexOf(name.toLocaleLowerCase()) === 0);
  }

  facultyFilter(name: string): Faculty[]{
    this.selectedUniversity = this.universityOption.filter(item => item.name === this.universityName)[0];
    this.getFaculty(name);
    this.facultyName = name;
    return this.facultyOption.filter(
      option => option.name.toLocaleLowerCase().indexOf(name.toLocaleLowerCase()) === 0);
  }

  departmentFilter(name: string): Department[]{
    this.selectedFaculty = this.facultyOption.filter( item => item.name === this.facultyName)[0];
    this.getDepartment(name);
    this.departmentName = name;
    return this.departmentOption.filter(
      option => option.name.toLocaleLowerCase().indexOf(name.toLocaleLowerCase()) === 0);
  }

  displayUniversity(university?: University): string | undefined{
    return university ? university.name: undefined;
  }

  displayCityFn(city?: City): string | undefined{
    return city ? city.name: undefined;
  }

  displayFacultyFn(faculty?: Faculty): string | undefined{
    return faculty ? faculty.name : undefined;
  }

  displayDepartmentFn(department?: Department): string | undefined{
    return department ? department.name : undefined;
  }






  constructor(private homePageService: HomePageService, private router: Router, private fb: FormBuilder) {
    this.cityOption = [];
    this.universityOption = [];
    this.facultyOption = [];
    this.departmentOption = [];
  }


  ngOnInit() {

    this.filteredCity = this.cityControl.valueChanges
      .pipe(
        startWith<string | City>(''),
        map(value => typeof value === 'string' ? value : value.name),
        map( name => name ? this.cityFilter(name) : this.cityOption.slice())
      );

    this.filteredUniversity = this.universityControl.valueChanges
      .pipe(
        startWith<string | University>(''),
        map( value => typeof value === 'string' ? value : value.name),
        map( name => name ? this.universityFilter(name) : this.universityOption.slice())
      );

    this.filteredFaculty = this.facultyControl.valueChanges
      .pipe(
        startWith<string | Faculty>(''),
        map(value => typeof value === 'string' ? value : value.name),
        map( name => name ? this.facultyFilter(name) : this.facultyOption.slice())
      );

    this.filteredDepartment = this.departmentControl.valueChanges
      .pipe(
        startWith<string | Department>(''),
        map( value => typeof  value === 'string' ? value : value.name),
        map(name => name ? this.departmentFilter(name) : this.departmentOption.slice())
      );

    this.getMyAccount();
    this.getNewEducation();
    this.cityForm = this.fb.group({
      inputCity: new FormControl(
        { value: ''},
        {validators: [Validators.required]})
    });

    this.cityDesForm = this.fb.group({
      inputCityDisable: new FormControl({value: '', disabled: true})
    })

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

  getUniversity(name){
    this.homePageService.getUniversity(name).subscribe( date => this.universityOption = date);
  }

  getFaculty(name: string){
    this.homePageService.getFaculty(name, this.selectedUniversity).subscribe( facultyDate => {
      this.facultyOption = facultyDate;
    })
  }

  getDepartment(name: string){
    this.homePageService.getDepartments(name, this.selectedFaculty).subscribe( departmentDate => {
      this.departmentOption = departmentDate;
    })
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

  getNewEducation(){
    this.homePageService.getAllTypesOfEducation().subscribe( date => {
      this.typeOfEducation = date;
    });
  }

  applyAddEducation(){

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


