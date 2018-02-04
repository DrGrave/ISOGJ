import {Component, OnInit} from '@angular/core';
import {HomePageService} from './home-page.service';
import {MyUser} from './MyUser';
import {Education} from "./Education";
import {UserCompany} from "./UserCompany";
import {UserLink} from "./UserLink";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Observable} from "rxjs/Observable";
import {startWith} from "rxjs/operators";
import {map} from 'rxjs/operators/map';
import {Skill} from "../user-list-page/skill";
import {Gender} from "./Gender";
import {Router} from "@angular/router";
import {TypeOfSkill} from "../user-list-page/TypeOfSkill";
import {NewSkill} from "./NewSkill";
import {City} from "./City";
import {University} from "./University";
import {TypeOfEducation} from "./TypeOfEducation";
import {Department} from "./Department";
import {Faculty} from "./Faculty";
import {MatDatepickerInputEvent} from "@angular/material";
import {Company} from "./Company";
import {Position} from "./Position";



@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  myUser: MyUser;
  username: string;
  education: Education[];
  userCompany: UserCompany[];
  imgLink: UserLink;
  links: UserLink[];
  skills: string;
  options: Skill[];
  skillName: string;
  selectSkill: Skill;
  show: boolean = false;
  typeOfSkillControl = new FormControl('', [Validators.required]);
  genderControl: FormControl = new FormControl('', [Validators.required]);
  typeOfSkills: TypeOfSkill[];
  newSkill: NewSkill;
  inputSkillForm: FormGroup;
  addedSkill = new Skill();
  removable: boolean = false;
  showUserInfoEdit: boolean = false;
  genderList: Gender[];
  selectedGender: Gender;
  isChangeEducation: boolean[];
  isChangeWork: boolean[];
  universityOption: University[];
  departmentOption: Department[];
  companyOption: Company[];
  positionOption: Position[];
  facultyOption: Faculty[];
  departmentName: string;
  universityName: string;
  companyName: string;
  positionName: string;
  typesOfEducation: TypeOfEducation[];
  selectedTypeOfEducation: TypeOfEducation;
  selectedUniversity: University;
  selectedFaculty: Faculty;
  selectedDepartment: Department;
  selectedCompany: Company;
  selectedPosition: Position;
  changedEducation: Education;
  newEducation: Education;
  private facultyName: string;
  changedDateOfStart: Date;
  changedDateOfEnd: Date;
  isAddCompanyAdd: boolean = false;
  addNewWork: UserCompany;

  test: string;





  constructor(private homePageService: HomePageService, private router: Router, private fb: FormBuilder) {
    this.myUser = new MyUser();
    this.education = [];
    this.myUser.gender = new Gender();
    this.options = [];
    this.genderList = [];
    this.universityOption =[];
    this.selectSkill = new Skill();
    this.newSkill = new NewSkill();
    this.addedSkill = new Skill();
    this.addedSkill.typeOfSkill = new TypeOfSkill();
    this.myUser.city = new City();
    this.isChangeEducation = [];
    this.isChangeWork = [];
    this.typesOfEducation = [];
    this.departmentOption = [];
    this.companyOption = [];
    this.positionOption = [];
    this.facultyOption = [];
    this.changedEducation = new Education();
    this.newEducation = new Education();
    this.addNewWork = new UserCompany();
  }

  myControl = new FormControl();
  filteredOptions: Observable<Skill[]>;
  universityControl = new FormControl();
  filteredUniversity: Observable<University[]>;
  filteredDepartment: Observable<Department[]>;
  filteredFaculty: Observable<Faculty[]>;
  filteredCompany: Observable<Company[]>;
  filteredPosition: Observable<Position[]>;
  typeOfEducationControl = new FormControl();
  departmentControl = new FormControl();
  facultyControl = new FormControl();
  ifAddEducationClicked: boolean = false;
  companyControl = new FormControl();
  positionControl = new FormControl();


  companyFilter(name: string): Company[]{
    this.getCompanys(name);
    this.companyName = name;
    return this.companyOption.filter( option =>
     option.name.toLocaleLowerCase().indexOf(name.toLocaleLowerCase()) === 0);
  }

  positionFilter(name: string): Position[]{
    this.getPositions(name);
    this.positionName = name;
    return this.positionOption.filter(option =>
     option.name.toLocaleLowerCase().indexOf(name.toLocaleLowerCase()) === 0)
  }

  filter(name: string): Skill[] {
    this.getSkills(name);
    this.skillName = name;
    return this.options.filter(option =>
      option.name.toLowerCase().indexOf(name.toLowerCase()) === 0);
  }

  universityFilter(name: string): University[]{
    this.getUniversity(name);
    this.universityName = name;
    return this.universityOption.filter(
      option => option.name.toLocaleLowerCase().indexOf(name.toLocaleLowerCase()) === 0);
  }

  departmentFilter(name: string): Department[]{
    this.selectedFaculty = this.facultyOption.filter( item => item.name === this.facultyName)[0];
    this.getDepartment(name);
    this.departmentName = name;
    return this.departmentOption.filter(
    option => option.name.toLocaleLowerCase().indexOf(name.toLocaleLowerCase()) === 0);

  }

  facultyFilter(name: string): Faculty[]{
    this.selectedUniversity = this.universityOption.filter(item => item.name === this.universityName)[0];
    this.getFaculty(name);
    this.facultyName = name;
    return this.facultyOption.filter(
      option => option.name.toLocaleLowerCase().indexOf(name.toLocaleLowerCase()) === 0);
  }

  getDepartment(name: string){
    this.homePageService.getDepartments(name, this.selectedFaculty).subscribe( departmentDate => {
      this.departmentOption = departmentDate;
    })
  }

  getFaculty(name: string){
    this.homePageService.getFaculty(name, this.selectedUniversity).subscribe( facultyDate => {
      this.facultyOption = facultyDate;
    })
  }

  getUniversity(name: string){
    this.homePageService.getUniversitys(name).subscribe( universityDate => {this.universityOption = universityDate});
  }

  displayCompanyFn(company?: Company): string | undefined{
    return company ? company.name: undefined;
  }
  displayPositionFn(position?: Position): string | undefined{
    return position ? position.name: undefined;
  }

  displayFn(skill?: Skill): string | undefined {
    return skill ? skill.name : undefined;
  }

  displayEducationFn(university?: University): string | undefined {
    return university ? university.name : undefined;
  }

  displayDepartmentFn(department?: Department): string | undefined{
    return department ? department.name : undefined;
  }

  displayFacultyFn(faculty?: Faculty): string | undefined{
    return faculty ? faculty.name : undefined;
  }

  ngOnInit() {

    this.inputSkillForm = this.fb.group({
      nameOfNewSkill: ['', Validators.required]
    });

    this.filteredCompany = this.companyControl.valueChanges
      .pipe(
        startWith<string | Company>(''),
        map( value => typeof value === 'string' ? value : value.name),
        map( name => name ? this.companyFilter(name) : this.companyOption.slice())
      );

    this.filteredPosition = this.positionControl.valueChanges
      .pipe(
        startWith<string | Position>(''),
        map( value => typeof  value === 'string' ? value : value.name),
        map(name =>name ? this.positionFilter(name) : this.positionOption.slice())
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

    this.filteredOptions = this.myControl.valueChanges
      .pipe(
        startWith<string | Skill>(''),
        map(value => typeof value === 'string' ? value : value.name),
        map(name => name ? this.filter(name) : this.options.slice())
      );

    this.imgLink = new UserLink();
    this.homePageService.getUserByToken().subscribe(data => {
      this.username = data;
      this.getMyAccount()

    });

  }


  getMyAccount(){
    this.homePageService.getUserByUsername(this.username).subscribe( data => {
      this.myUser = data;
      this.getImg();
      this.getMyLinks();
      this.getMyEducation();
      this.getMyCompany();
      this.getMySkills();
      this.getSkills("");

    });
  }

  getMyEducation(){
    this.homePageService.getEducation(this.myUser.id).subscribe( educationDate => {
      this.education = educationDate;
    });
  }

  getMyCompany(){
    this.homePageService.getMyCompany(this.myUser.id).subscribe( companyDate => {
      this.userCompany = companyDate;
    })
  }

  getMySkills(){
    this.homePageService.getMySkills(this.myUser.id).subscribe( skillDate => {
      this.myUser.skill = skillDate;
    })
  }

  getMyLinks(){
    this.homePageService.getUserLinks(this.myUser.id).subscribe( linksDate =>{
      this.links = linksDate;
    })
  }

  getSkills(name: string){
    this.homePageService.getAddedSkills(name).subscribe( skillsDate =>{
      this.options = skillsDate;
    })
  }

  getImg(){
    this.homePageService.getUserImg(this.myUser.id).subscribe( img =>{
      this.imgLink = img;
    })
  }

  addSkill(){
    this.selectSkill = this.options.filter(item => item.name === this.skillName)[0];
    if (typeof this.selectSkill !== 'undefined'){
      this.homePageService.addSkill(this.selectSkill, this.myUser.id).subscribe( skillsDate => this.myUser.skill = skillsDate );
      this.skills = this.selectSkill.name;
    } else {
      this.skills = 'undefined';
    }
  }

  getAllTypesOfSkill(){
    this.homePageService.getAllTypesOfSkills().subscribe( typeOfSkillsDate => this.typeOfSkills = typeOfSkillsDate);
  }

  showAddSkill(){
      this.show = !this.show;
      this.getAllTypesOfSkill();
  }

  acceptCreateSkill(){
    this.newSkill = this.inputSkillForm.value;
    this.addedSkill.name = this.newSkill.nameOfNewSkill;
    this.show = !this.show;
    this.homePageService.addNewSkill(this.addedSkill).subscribe() ;
  }

  refine($event, item) {
    this.addedSkill.typeOfSkill = item;
  }

  showRemoveSkill(){
    this.removable = !this.removable;
  }

  removeSkill($event, skill){
    this.homePageService.removeSkills(this.myUser.id, skill).subscribe(skill => this.myUser.skill = skill);
  }

  showEditUserInfo(){

    this.showUserInfoEdit = !this.showUserInfoEdit;
    this.getAllGenders();

    this.selectedGender = this.myUser.gender;

  }

  getAllGenders(){
    this.homePageService.getAllGenders().subscribe( genders => this.genderList = genders);
  }

  applyChangeGender(){
    this.homePageService.changeGender(this.selectedGender, this.myUser.id).subscribe( gender => this.myUser.gender = gender);
    this.showUserInfoEdit = !this.showUserInfoEdit;
  }

  getAllTypesOfEducation(){
    this.homePageService.getAllTypesOfEducation().subscribe( typesEducation => this.typesOfEducation = typesEducation);
  }

  genderApply($event, gender){
    this.selectedGender = gender;
  }

  changeCity(){

  }


  addEducation(){
    this.ifAddEducationClicked = !this.ifAddEducationClicked;
  }

  changeWork(company){
    this.isChangeWork[company.idUserCompany] = !this.isChangeWork[company.idUserCompany];
  }

  addWork(){
    this.isAddCompanyAdd = !this.isAddCompanyAdd;
  }

  changeEmail(){

  }

  changeLink(link){

  }

  addLink(){

  }

  editSkill(skill){

  }

  applyChangeEducation(educate){
    this.selectedDepartment = this.departmentOption.filter(item => item.name === this.departmentName)[0];
    this.changedEducation = educate;
    if (this.selectedDepartment != null) {
      this.changedEducation.department = this.selectedDepartment;
    }
    if (this.changedDateOfStart != null){
      this.changedEducation.dateOfStart = this.changedDateOfStart.getTime();
    }
    if (this.changedDateOfEnd != null){
      this.changedEducation.dateOfEnd = this.changedDateOfEnd.getTime();
    }
    this.homePageService.changeEducation(this.changedEducation, this.myUser.id).subscribe(date => {
    });
    this.isChangeEducation[educate.id] = !this.isChangeEducation[educate.id];
  }

  changeEducation(educate){
    this.isChangeEducation[educate.id] = !this.isChangeEducation[educate.id];
    this.getAllTypesOfEducation();
  }

  deleteEducation(educate){
    this.homePageService.deleteEducation(educate, this.myUser.id).subscribe( date => this.education = date);
  }

  applyChangeCompany(company){
    if (this.selectedCompany != null){
      company.company = this.selectedCompany;
    }
    if (this.selectedPosition != null){
      company.position = this.selectedPosition;
    }
    this.homePageService.changeCompany(company, this.myUser.id).subscribe(date => this.userCompany = date);
    this.isChangeWork[company.idUserCompany] = !this.isChangeWork[company.idUserCompany];
  }

  deleteWork(company){
    this.homePageService.deleteCompany(company, this.myUser.id).subscribe(date => this.userCompany = date);
  }

  changeUniversity(educate) {

  }

  typeOfEducationApply($event, type){
    this.selectedTypeOfEducation = type;
  }

  changeFaculty(educate: Education) {

  }

  changeDepartment(educate: Education) {

  }

  applyAddEducation() {
    this.selectedDepartment = this.departmentOption.filter(item => item.name === this.departmentName)[0];
    this.newEducation.department = this.selectedDepartment;
    this.newEducation.typeOfEducation = this.selectedTypeOfEducation;
    this.homePageService.addEducation(this.newEducation, this.myUser.id).subscribe(date => this.education = date);
    this.ifAddEducationClicked = !this.ifAddEducationClicked;
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

  changeCompany() {
    this.selectedCompany = this.companyOption.filter(item => item.name === this.companyName)[0];
  }

  changePosition() {
    this.selectedPosition = this.positionOption.filter(item => item.name === this.positionName)[0];
  }

  private getCompanys(name: string) {
    this.homePageService.getCompanys(name).subscribe(companys => this.companyOption = companys);
  }

  private getPositions(name: string) {
    this.homePageService.getPositions(name).subscribe( positions => this.positionOption = positions);
  }

  applyAddWork() {
    this.addNewWork.company = this.companyOption.filter(item => item.name === this.companyName)[0];
    this.addNewWork.position = this.positionOption.filter(item => item.name === this.positionName)[0];
    this.homePageService.addCompany(this.addNewWork, this.myUser.id).subscribe(date => this.userCompany = date);
    this.isAddCompanyAdd = !this.isAddCompanyAdd;
  }

  declineCompany() {
    this.isAddCompanyAdd = !this.isAddCompanyAdd;
  }
}


