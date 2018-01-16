import {Component, OnInit} from '@angular/core';
import {HomePageService} from './home-page.service';
import {MyUser} from './MyUser';
import {Education} from "./Education";
import {Faculty} from "./Faculty";
import {TypeOfEducation} from "./TypeOfEducation";
import {School} from "./School";
import {forEach} from "@angular/router/src/utils/collection";
import {UserCompany} from "./UserCompany";
import {UserLink} from "./UserLink";
import {FormControl, FormGroup} from "@angular/forms";
import {Observable} from "rxjs/Observable";
import {startWith} from "rxjs/operators";
import {map} from 'rxjs/operators/map';
import {Skill} from "../user-list-page/skill";



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
  skills: Skill[];
  inputSkill: FormGroup;

  myControl = new FormControl();
  filteredOptions: Observable<User[]>;

  displayFn(skill?: Skill): string | undefined {
    return skill ? skill.name : undefined;
  }


  filter(name: string): User[] {
    return this.skills.filter(option =>
      option.name.toLowerCase().indexOf(name.toLowerCase()) === 0);
  }

  constructor(private homePageService: HomePageService) {
    this.myUser = new MyUser();
    this.education = [];
    this.skills = [];
  }

  ngOnInit() {
    this.filteredOptions = this.myControl.valueChanges
      .pipe(
        startWith<string | Skill>(''),
        map(value => typeof value === 'string' ? value : value.name),
        map(name => name ? this.filter(name) : this.skills.slice())
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
      this.getMyLinks();
      this.getMyEducation();
      this.getMyCompany();
      this.getMySkills();
      this.getSkills();
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
      this.imgLink = this.links[0];
    })
  }

  getSkills(){
    this.homePageService.getAddedSkills("").subscribe( skillsDate =>{
      this.skills = skillsDate;
    })
  }
}
