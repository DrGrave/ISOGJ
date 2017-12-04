import {Component, OnInit} from '@angular/core';
import {RegUser} from "./reg-user";
import {RegUserPageService} from "./reg-user-page.service";

@Component({
    selector: 'reg-page',
    templateUrl: './reg-page.component.html',
    styleUrls: ['./reg-page.component.scss']
})
export class RegPageComponent implements OnInit {

    constructor(private registerService : RegUserPageService){}

    regUser : RegUser;
    regNew: RegUser;
    secPass : string;

    ngOnInit(): void {
      this.regUser = new RegUser;
    }

  private regMyUser(event) {
    this.registerService.addRegUser(this.regUser).subscribe(user => this.regNew = user)
  }
}
