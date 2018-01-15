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


  constructor(private homePageService: HomePageService) {
    this.myUser = new MyUser();
    this.education = [];
  }

  ngOnInit() {
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
}
