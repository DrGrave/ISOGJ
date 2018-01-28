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


export class User {
  constructor(public name: string) { }


}

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
  universityName: string;







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
  }

  myControl = new FormControl();
  filteredOptions: Observable<Skill[]>;
  universityControll = new FormControl();
  filteredUniversity: Observable<University[]>;

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

  getUniversity(name: string){
    this.homePageService.getUniversitys(name).subscribe( universityDate => {this.universityOption = universityDate});
  }

  displayFn(skill?: Skill): string | undefined {
    return skill ? skill.name : undefined;
  }

  displayEducationFn(university?: University): string | undefined {
    return university ? university.name : undefined;
  }

  ngOnInit() {

    this.inputSkillForm = this.fb.group({
      nameOfNewSkill: ['', Validators.required]
    });

    this.filteredUniversity = this.universityControll.valueChanges
      .pipe(
        startWith<string | University>(''),
        map( value => typeof value === 'string' ? value : value.name),
        map( name => name ? this.universityFilter(name) : this.universityOption.slice())
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

  genderApply($event, gender){
    this.selectedGender = gender;
  }

  changeCity(){

  }


  addEducation(){

  }

  changeWork(work){
    this.isChangeWork[work.idUserCompany] = !this.isChangeWork[work.idUserCompany];
  }

  addWork(){

  }

  changeEmail(){

  }

  changeLink(link){

  }

  addLink(){

  }

  editSkill(skill){

  }

  applyChangeEducation(){

  }

  changeEducation(educate){
    this.isChangeEducation[educate.id] = !this.isChangeEducation[educate.id];
  }

  deleteEducation(educate){

  }

  applyChangeCompany(){

  }

  deleteWork(company){

  }

  changeUniversity(educate) {

  }
}


