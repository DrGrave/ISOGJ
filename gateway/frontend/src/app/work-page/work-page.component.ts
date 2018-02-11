import { Component, OnInit } from '@angular/core';
import {UserCompany} from "../home-page/UserCompany";

import {MyUser} from "../home-page/MyUser";
import {CompanyPageService} from "./company-page.service";
import {Position} from "../home-page/Position";
import {Company} from "../home-page/Company";

@Component({
  selector: 'app-work-page',
  templateUrl: './work-page.component.html',
  styleUrls: ['./work-page.component.scss']
})
export class WorkPageComponent implements OnInit {

  myUser: MyUser;
  mainCompany: UserCompany;

  constructor(private companyPageService: CompanyPageService) {

  }

  ngOnInit() {
       this.myUser = JSON.parse(localStorage.getItem('myUser'));
       this.getMainCompany();
  }

    getMainCompany(){
      this.companyPageService.getMainCompany(this.myUser.id).subscribe( date => this.mainCompany = date);
    }

    getNextCompany(){
      this.companyPageService.getNextMainNextCompany(this.myUser.id, this.mainCompany.idUserCompany).subscribe( date => this.mainCompany = date);
    }
}
