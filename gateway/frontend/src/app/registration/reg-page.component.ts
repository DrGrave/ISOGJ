import {Component, OnInit} from '@angular/core';
import {RegUser} from "./reg-user";
import {RegUserPageService} from "./reg-user-page.service";
import {isUndefined} from "util";


@Component({
    selector: 'reg-page',
    templateUrl: './reg-page.component.html',
    styleUrls: ['./reg-page.component.scss']
})
export class RegPageComponent implements OnInit {

    constructor(private registerService : RegUserPageService){}
    loginField : string;
    emailField : string;
    regUser : RegUser = new RegUser;
    regNew: RegUser;
    secPass : string;


    ngOnInit(): void {
      this.registerService
    }

  private regMyUser(event) {
      this.registerService.addRegUser(this.regUser).subscribe(user => this.regNew = user)
  }


  checkLogin(event){
        this.registerService.checkLogin(this.regUser).subscribe(data => this.loginField = data)
    }

    checkMail(event) {
        this.registerService.checkEmail(this.regUser).subscribe(data => this.emailField = data)
    }
}
