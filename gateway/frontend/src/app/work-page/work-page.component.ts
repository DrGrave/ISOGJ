import { Component, OnInit } from '@angular/core';
import {UserCompany} from "../home-page/UserCompany";

import {MyUser} from "../home-page/MyUser";
import {CompanyPageService} from "./company-page.service";
import {Position} from "../home-page/Position";
import {Company} from "../home-page/Company";
import {User} from "../user-list-page/user";
import {HomePageService} from "../home-page/home-page.service";
import {UserService} from "../user-list-page/user-list-page.service";
import {UserWork} from "./UserWork";
import {Vacancy} from "../vacancy-list-page/vacancy";
import {WorkVacancy} from "./WorkVacancy";

@Component({
  selector: 'app-work-page',
  templateUrl: './work-page.component.html',
  styleUrls: ['./work-page.component.scss']
})
export class WorkPageComponent implements OnInit {

  myUser: MyUser;
  mainCompany: UserCompany;
  users: UserWork[];
  nusers: UserWork[];
  vacancys: WorkVacancy[];

  constructor(private companyPageService: CompanyPageService, private userService: UserService) {
    this.mainCompany = new UserCompany();
    this.mainCompany.company = new Company();
    this.mainCompany.company.cityOfCompany = new Company();
    this.users = [];
    this.nusers = [];
  }

  ngOnInit() {
       this.myUser = JSON.parse(localStorage.getItem('myUser'));
       this.getMainCompany();

  }

    getMainCompany(){
      this.companyPageService.getMainCompany(this.myUser.uid).subscribe( date => {
        this.mainCompany = date;
        this.getCompanyUsers();
        this.getCompanyNUsers();
        this.getVacancys();
      });
    }

    getNextCompany(){
      this.companyPageService.getNextMainNextCompany(this.myUser.uid, this.mainCompany.idUserCompany).subscribe( date => this.mainCompany = date);
    }

    getCompanyUsers(){
      this.companyPageService.getUsersToCompany(this.mainCompany.company.id).subscribe(date => {
        this.users = date;
        this.getUsersImg(this.users);
      });
    }

    getCompanyNUsers(){
      this.companyPageService.getNotUsersToCompany(this.mainCompany.company.id).subscribe(date => {
        this.nusers = date;
        this.getUsersImg(this.nusers);
      });
    }

    getVacancys(){
      this.companyPageService.getVacancys(this.mainCompany.company.id).subscribe( date => {
        this.vacancys = date;
        this.getVacancySkills(this.vacancys);
      });
    }
    getVacancyUser(){

    }

    getVacancySkills(skillArr: WorkVacancy[]){

    }



    getVacancyNUser(){

    }
    getTasks(){

    }

    private getUsersImg(userArr: UserWork[]) {
      for (let i = 0; i < userArr.length; i++) {
      }
    }
}
