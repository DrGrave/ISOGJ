import {Component, OnInit, ViewChild} from '@angular/core';
import {HomePageService} from './home-page.service';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {MatDatepickerInputEvent, MatPaginator} from "@angular/material";
import {FullUserInfo} from "./FullUserInfo";
import {Gender} from "./Gender";
import {City} from "./City";
import {map, startWith} from "rxjs/operators";
import {TypeOfEducation} from "./TypeOfEducation";
import {University} from "./University";
import {Faculty} from "./Faculty";
import {Department} from "./Department";
import {Education} from "./Education";
import {Company} from "./Company";
import {SkillsToPosition} from "./SkillsToPosition";
import {Skill} from "../user-list-page/skill";


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  newEducation: Education;
  ifEditEducationClick: boolean = false;


  newDepartment: Department;

  ifOk: true;

  cityList: City[];
  universityList: University[];
  facultyList: Faculty[];
  departmentList: Department[];
  companyList: Company[];
  positionList: SkillsToPosition[];
  skillList: Skill[];

  positionSkillCtrl: FormControl;
  positionCtrl: FormControl;
  companyNameCtrl: FormControl;
  universityCtrl: FormControl;
  changeUniversityCtrl: FormControl;
  cityCtrl: FormControl;
  facultyCtrl: FormControl;
  changeFacultyCtrl: FormControl;
  departmentCtrl: FormControl;
  changeDepartmentCtrl: FormControl;


  reactivePositionSkill: any;
  reactivePosition: any;
  reactiveFaculty: any;
  reactiveUniversity: any;
  reactiveCity: any;
  reactiveDepartment: any;
  reactiveCompany: any;

  skills: Skill[];
  universitys: University[];
  citys: City[];
  facultys: Faculty[];
  departments: Department[];
  companys: Company[];
  positions: SkillsToPosition[];


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
  changeWorkKlick: boolean = false;
  selectedGender;
  selectedEditTypeOfEducation;
  selectedEdTypeOfEducation: TypeOfEducation;
  ifAddClick = true;


  selectedUniversity: University;
  selectedFaculty: Faculty;
  selectedCompany: Company;
  selectedPosition: SkillsToPosition;

  facultyOption: Faculty[];
  departmentOption: Department[];


  universityName: string;
  cityName: string;
  facultyName: string;
  departmentName: string;
  companyName: string;
  positionName: string;
  skillName: string;

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
    this.positions = [];
    this.skills = [];

    this.cityList = [];
    this.universityList = [];
    this.facultyList = [];
    this.departmentList = [];
    this.companyList = [];
    this.positionList = [];
    this.skillList = [];

    this.universityCtrl = new FormControl({id:  '', name: ''}, [Validators.required]);

    this.companyNameCtrl = new FormControl({id:'', name:''}, [Validators.required]);

    this.positionSkillCtrl = new FormControl({id: '', name:''}, [Validators.required]);
    this.reactivePositionSkill = this.positionSkillCtrl.valueChanges
      .pipe(
        startWith(),
        map(value => this.displayFn(value)),
        map(name => this.positionSkillFilter(name, this.skills))
      );

    this.reactiveCompany = this.companyNameCtrl.valueChanges
      .pipe(
        startWith(),
        map(value => this.displayFn(value)),
        map( name => this.companyFilter(name, this.companys))
      );

    this.positionCtrl = new FormControl({id:'', name:''}, [Validators.required]);
    this.reactivePosition = this.positionCtrl.valueChanges
      .pipe(
        startWith(),
        map(value => this.displayFn(value)),
        map( name => this.positionFilter(name, this.positions))
      );

    this.departmentCtrl = new FormControl({id: '', name: '', specialization: ''}, [Validators.required]);
    this.reactiveDepartment = this.departmentCtrl.valueChanges
      .pipe(
        startWith(this.departmentCtrl.value),
        map( value => this.displayFn(value)),
        map(name => this.departmentFilter(name, this.departments))
      );

    this.facultyCtrl = new FormControl({id: '', name: ''}, [Validators.required]);
    this.reactiveFaculty = this.facultyCtrl.valueChanges
      .pipe(
        startWith(this.facultyCtrl.value),
        map( value => this.displayFn(value)),
        map( name => this.facultyFilter(name, this.facultys))
      );



    this.reactiveUniversity = this.universityCtrl.valueChanges
      .pipe(
        startWith(this.universityCtrl.value),
        map(val => this.displayFn(val)),
        map(name => this.universityFilter(name, this.universitys))
      );



    this.facultyOption = [];
    this.departmentOption = [];
    this.newEducation = new Education;


  }



  displayFn(value: any): string {
    return value && typeof value === 'object' ? value.name : value;
  }


  positionSkillFilter(val: string, options: any[]){
    this.skillName = val;
    options = this.getSkills(val);
    return this.filter(val, options);
  }

  getSkills(name: string): Skill[]{
    this.homePageService.getSkillsByPartName(name).subscribe(date => this.skillList = date);
    return this.skillList;
  }

  departmentFilter(val: string, options: any[]){
    this.departmentName = val;
    if (this.facultyList.filter( item => item.name === this.facultyName)[0]) {
      this.selectedFaculty = this.facultyList.filter(item => item.name === this.facultyName)[0];
      options = this.getDepartment(val, this.selectedFaculty);
      return this.filter(val, options);
    }
  }

  positionFilter(val: string, options: any[]){
    this.positionName = val;
    options = this.getPositions(val);
    if (this.positionList.filter(item => item.name === this.positionName)[0]){
      this.selectedPosition = this.positionList.filter(item => item.name === this.positionName)[0];
    }
    return this.filter(val, options);
  }

  getPositions(val: string): SkillsToPosition[]{
    this.homePageService.getPositions( 1, val).subscribe(date => this.positionList = date);
    return this.positionList;
  }


  applyAddCompany(){

  }

  facultyFilter(val: string, options: any[]){
    this.facultyName = val;
    if (this.universityList.filter(item => item.name === this.universityName)[0]){
      this.selectedUniversity = this.universityList.filter(item => item.name === this.universityName)[0];
      options = this.getFaculty(val, this.selectedUniversity);
      return this.filter(val, options);
    }
  }

  cityFilter(val: string, options: any[]){
    options = this.getCity(val);
    this.cityName = val;
    return this.filter(val, options);
  }

  companyFilter(val: string, options: any[]){
    options = this.getCompanys(val);
    this.companyName = val;
    this.selectedCompany = options.filter(item => item.name === val)[0];
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

  deleteSkillFromPositionAdd(skill){
    let ind = this.selectedPosition.skills.indexOf(skill, 0);
    this.selectedPosition.skills.splice(ind, 1)
  }

  applyAddPositionSKill(){
    if (this.skillList.filter(item => item.name === this.skillName)[0]) {
      let selectedPositionSkill = this.skillList.filter(item => item.name === this.skillName)[0];
      if (!this.selectedPosition.skills.filter(item => item.name === selectedPositionSkill.name)[0]) {
        this.selectedPosition.skills.push(selectedPositionSkill);
      }
    } else {
        this.homePageService.addNewSkill(this.skillName).subscribe(date => {
          this.selectedPosition.skills.push(date);
          this.skillList.push(date);
        });

    }
  }

  applyAddPosition(){
    if (this.positionList.filter(item => item.name === this.positionName)[0]){
    } else{
      this.homePageService.saveNewPosition(this.positionName).subscribe(date => {
        this.selectedPosition = date;
        this.positionList.push(date);
      });

    }
  }

  addNewCompany(){
    if (this.companyList.filter(item => item.name === this.companyName)[0]){

    } else{
      this.homePageService.saveNewCompany(this.companyName).subscribe( date =>{
        this.selectedCompany = date;
        this.companyList.push(date);
      });
    }
  }

  getMyAccount(){
    this.homePageService.getSizeHistory().subscribe(date =>{
      this.historyCount = date;
    });
    this.homePageService.getUser().subscribe( data => {
      this.myUser = data;
      this.getGenders();
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

  getCompanys(name: string): Company[]{
    this.homePageService.getCompanys(name).subscribe( date => this.companyList = date);
    return this.companyList;
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
    this.ifEditEducationClick = false;
    this.homePageService.getAllTypesOfEducation().subscribe( date => {
      this.typeOfEducation = date;
      this.selectedEditTypeOfEducation = date[0].id;
    });
  }

  addWorkClick(){

  }

  nextEducation(){
    this.ifEditEducationClick = false;
  }

  applyAddEducation(){
    this.newEducation.typeOfEducation = this.selectedTypeOfEducation;
    this.newDepartment = new Department;
    this.newDepartment.faculty = new Faculty;
    this.newDepartment.faculty.university = new University;
    if (!this.universityList.filter(item => item.name === this.universityName)[0]){
      this.newDepartment.faculty.university.name = this.universityName;
      this.newDepartment.faculty.name = this.facultyName;
      this.newDepartment.name = this.departmentName;
      this.newEducation.department = this.newDepartment;
      this.newEducation.dateOfStart = this.changedDateOfStart.getTime();
      this.newEducation.dateOfEnd = this.changedDateOfEnd.getTime();
      this.homePageService.addEducation(this.newEducation).subscribe(date => this.myUser.educationSkillsDtoList = date);
    }else if(!this.facultyList.filter( item => item.name === this.facultyName)[0]){
      this.newDepartment.faculty.university = this.selectedUniversity;
      this.newDepartment.faculty.name = this.facultyName;
      this.newDepartment.name = this.departmentName;
      this.newEducation.department = this.newDepartment;
      this.newEducation.dateOfStart = this.changedDateOfStart.getTime();
      this.newEducation.dateOfEnd = this.changedDateOfEnd.getTime();
      this.homePageService.addEducation(this.newEducation).subscribe(date => this.myUser.educationSkillsDtoList = date);
    }else if(!this.departmentList.filter(item => item.name === this.departmentName)[0]){
      this.newDepartment.faculty.university = this.selectedUniversity;
      this.newDepartment.faculty = this.selectedFaculty;
      this.newDepartment.name = this.departmentName;
      this.newEducation.department = this.newDepartment;
      this.newEducation.dateOfStart = this.changedDateOfStart.getTime();
      this.newEducation.dateOfEnd = this.changedDateOfEnd.getTime();
      this.homePageService.addEducation(this.newEducation).subscribe(date => this.myUser.educationSkillsDtoList = date);
    }else{
      this.newEducation.department =  this.departmentList.filter( item => item.name === this.departmentName)[0];
      this.newEducation.dateOfStart = this.changedDateOfStart.getTime();
      this.newEducation.dateOfEnd = this.changedDateOfEnd.getTime();
      this.homePageService.addEducation(this.newEducation).subscribe(date => this.myUser.educationSkillsDtoList = date);
    }
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

  deleteEducation(educate){
    this.homePageService.deleteEducate(educate.educationDto).subscribe( date => this.myUser.educationSkillsDtoList = date
    );
  }

  editEducation(educate){
    this.ifEditEducationClick = !this.ifEditEducationClick;
    this.selectedEditTypeOfEducation = educate.educationDto.typeOfEducation.id;
    this.changedDateOfStart = new Date(educate.educationDto.dateOfStart);
    this.changedDateOfEnd = new Date(educate.educationDto.dateOfEnd);
    this.getUniversity(educate.educationDto.department.faculty.university.name);
    this.getFaculty(educate.educationDto.department.faculty.name, educate.educationDto.department.faculty.university);
    this.getDepartment(educate.educationDto.department.name, educate.educationDto.department.faculty);

    this.changeFacultyCtrl = new FormControl({id: educate.educationDto.department.faculty.id, name: educate.educationDto.department.faculty.name});
    this.reactiveFaculty = this.changeFacultyCtrl.valueChanges
      .pipe(
        startWith(this.changeFacultyCtrl.value),
        map( value => this.displayFn(value)),
        map( name => this.facultyFilter(name, this.facultys))
      );

    this.changeDepartmentCtrl = new FormControl({id: educate.educationDto.department.id, name: educate.educationDto.department.name});

    this.reactiveDepartment = this.changeDepartmentCtrl.valueChanges
      .pipe(
        startWith(this.changeDepartmentCtrl.value),
        map( value => this.displayFn(value)),
        map(name => this.departmentFilter(name, this.departments))
      );

    this.changeUniversityCtrl = new FormControl({id:  educate.educationDto.department.faculty.university.id, name: educate.educationDto.department.faculty.university.name}, [Validators.required]);
    this.reactiveUniversity = this.changeUniversityCtrl.valueChanges
      .pipe(
        startWith(this.changeUniversityCtrl.value),
        map(val => this.displayFn(val)),
        map(name => this.universityFilter(name, this.universitys))
      );
  }

  applyEditEducation(educate){
    this.selectedEdTypeOfEducation = this.typeOfEducation.find(c => c.id == this.selectedEditTypeOfEducation);
    educate.educationDto.typeOfEducation = this.selectedEdTypeOfEducation;
    this.newDepartment = new Department;
    this.newDepartment.faculty = new Faculty;
    this.newDepartment.faculty.university = new University;
    if (!this.universityList.filter(item => item.name === this.universityName)[0]){
      this.newDepartment.faculty.university.name = this.universityName;
      this.newDepartment.faculty.name = this.facultyName;
      this.newDepartment.name = this.departmentName;
      educate.educationDto.department = this.newDepartment;
      educate.educationDto.dateOfStart = this.changedDateOfStart.getTime();
      educate.educationDto.dateOfEnd = this.changedDateOfEnd.getTime();
      this.homePageService.changeEducation(educate.educationDto).subscribe(date => this.myUser.educationSkillsDtoList = date);
    }else if(!this.facultyList.filter( item => item.name === this.facultyName)[0]){
      this.newDepartment.faculty.university = this.selectedUniversity;
      this.newDepartment.faculty.name = this.facultyName;
      this.newDepartment.name = this.departmentName;
      educate.educationDto.department = this.newDepartment;
      educate.educationDto.dateOfStart = this.changedDateOfStart.getTime();
      educate.educationDto.dateOfEnd = this.changedDateOfEnd.getTime();
      this.homePageService.changeEducation(educate.educationDto).subscribe(date => this.myUser.educationSkillsDtoList = date);
    }else if(!this.departmentList.filter(item => item.name === this.departmentName)[0]){
      this.newDepartment.faculty.university = this.selectedUniversity;
      this.newDepartment.faculty = this.selectedFaculty;
      this.newDepartment.name = this.departmentName;
      educate.educationDto.department = this.newDepartment;
      educate.educationDto.dateOfStart = this.changedDateOfStart.getTime();
      educate.educationDto.dateOfEnd = this.changedDateOfEnd.getTime();
      this.homePageService.changeEducation(educate.educationDto).subscribe(date => this.myUser.educationSkillsDtoList = date);
    }else{
      educate.educationDto.department =  this.departmentList.filter( item => item.name === this.departmentName)[0];
      educate.educationDto.dateOfStart = this.changedDateOfStart.getTime();
      educate.educationDto.dateOfEnd = this.changedDateOfEnd.getTime();
      this.homePageService.changeEducation(educate.educationDto).subscribe(date => this.myUser.educationSkillsDtoList = date);
    }
    this.ifEditEducationClick = !this.ifEditEducationClick;
  }

  editWork(company){
    this.changeWorkKlick = !this.changeWorkKlick;
  }

  deleteWork(company){

  }

  applyChangeWork(company){
    this.changeWorkKlick = !this.changeWorkKlick;
  }
}


