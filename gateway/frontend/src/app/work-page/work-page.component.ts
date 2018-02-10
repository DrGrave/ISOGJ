import { Component, OnInit } from '@angular/core';
import {UserCompany} from "../home-page/UserCompany";
import {WorkPageService} from "./work-page.service";
import {MyUser} from "../home-page/MyUser";

@Component({
  selector: 'app-work-page',
  templateUrl: './work-page.component.html',
  styleUrls: ['./work-page.component.scss']
})
export class WorkPageComponent implements OnInit {

  myUser: MyUser;
  mainCompany: UserCompany;

  constructor(private workPageService: WorkPageService) {
    this.mainCompany = new UserCompany();
  }

  ngOnInit() {
    this.getMainCompany();
  }

  getMainCompany(){
    this.workPageService.getMainCompany(this.myUser.id).subscribe( date => this.mainCompany = date);
  }

  getNextCompany(){
    this.workPageService.getNextMainNextCompany(this.myUser.id, this.mainCompany.idUserCompany).subscribe( date => this.mainCompany = date);
  }
}
