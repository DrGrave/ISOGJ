import {Component, OnInit} from '@angular/core';
import {RegUser} from './reg-user';
import {RegUserPageService} from './reg-user-page.service';
import {FormControl, FormGroup, NgModel, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {logger} from "codelyzer/util/logger";


@Component({
  selector: 'app-reg-page',
  templateUrl: './reg-page.component.html',
  styleUrls: ['./reg-page.component.scss']
})

export class RegPageComponent implements OnInit {

  constructor(private registerService: RegUserPageService, private router: Router) {
  }

  ifLoginFree: boolean;
  ifEmailFree: boolean;
  ifRegisterOk: boolean;
  regUser: RegUser = new RegUser;
  regNew: RegUser;
  secPass: string;
  userNameError: string;
  emailError: string;

  ngOnInit(): void {
  }

  private regMyUser() {
    this.registerService.addRegUser(this.regUser).subscribe(user => {this.ifRegisterOk = user;
    this.sucsReg() });

  }

  sucsReg(){
    if (this.ifRegisterOk){
      this.router.navigateByUrl("/registration-success-page");
    } else {
      //error
    }
  }


  checkLogin() {
    this.registerService.checkLogin(this.regUser).subscribe(data => {this.ifLoginFree = data;
    this.logField() });
  }

  logField(){
    if (!this.ifLoginFree){
      this.userNameError = "This username already exist"
    }else {
      this.userNameError = ""
    }
  }

  checkMail() {
    this.registerService.checkEmail(this.regUser).subscribe(data => {this.ifEmailFree = data;
    this.mailField() });

  }

  mailField(){
    if (!this.ifEmailFree){
      this.emailError = "This email already exist"
    }else {
      this.emailError = ""
    }
  }
}
