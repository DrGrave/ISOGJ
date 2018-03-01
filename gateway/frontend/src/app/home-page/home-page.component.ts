import {Component, OnInit} from '@angular/core';
import {HomePageService} from './home-page.service';
import {MyUser} from './MyUser';
import {Education} from "./Education";
import {UserCompany} from "./UserCompany";
import {UserLink} from "./UserLink";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

import {Skill} from "../user-list-page/skill";
import {Gender} from "./Gender";
import {Router} from "@angular/router";
import {TypeOfSkill} from "../user-list-page/TypeOfSkill";
import {NewSkill} from "./NewSkill";
import {City} from "./City";
import {MatDatepickerInputEvent} from "@angular/material";
import {Company} from "./Company";
import {TypeOfLink} from "./TypeOfLink";
import {NewLink} from "./NewLink";
import {NewCompany} from "./NewCompany";



@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  myUser: MyUser;
  username: string;
  link: string;






  constructor(private homePageService: HomePageService, private router: Router, private fb: FormBuilder) {
    this.myUser = new MyUser();
  }


  ngOnInit() {
    this.getMyAccount();
  }

  getMyAccount(){
    this.homePageService.getUser().subscribe( data => {
      this.myUser = data;
      this.getImg();
      localStorage.setItem('myUser', JSON.stringify(this.myUser));
    });
  }

  getImg(){
    this.homePageService.getUserImage().subscribe( image =>{
      this.link = image.link;
    });
  }
}


