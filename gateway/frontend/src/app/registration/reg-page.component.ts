import {Component, OnInit} from '@angular/core';
import {RegUser} from './reg-user';
import {RegUserPageService} from './reg-user-page.service';


@Component({
  selector: 'app-reg-page',
  templateUrl: './reg-page.component.html',
  styleUrls: ['./reg-page.component.scss']
})
export class RegPageComponent implements OnInit {

    constructor(private registerService: RegUserPageService) {}
    ifLoginFree: boolean;
    ifEmailFree: boolean;
    regUser: RegUser = new RegUser;
    regNew: RegUser;
    secPass: string;


  ngOnInit(): void {
    this.registerService;
  }

  private regMyUser() {
    this.registerService.addRegUser(this.regUser).subscribe(user => this.regNew = user);
  }


  checkLogin() {
    this.registerService.checkLogin(this.regUser).subscribe(data => this.ifLoginFree = data);
  }

  checkMail() {
    this.registerService.checkEmail(this.regUser).subscribe(data => this.ifEmailFree = data);
  }
}
