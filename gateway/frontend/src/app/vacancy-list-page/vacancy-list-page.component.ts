

import {Component, OnInit} from "@angular/core";
import {User} from "../user-list-page/user";
import {VacancyService} from "./vacancy-list-page.service";
import {Vacancy} from "./vacancy";

@Component({
  selector: 'app-company-list-page',
  templateUrl: './vacancy-list-page.component.html',
  styleUrls: ['./vacancy-list-page.component.scss']
})

export class CompanyListPageComponent implements OnInit{


  ngOnInit(): void {
    this.getVacancys()
  }

  constructor(private vacancyService: VacancyService){}
  vacancys : Vacancy[];

  getVacancys(): void{
    this.vacancyService.getVacancy().subscribe(vacancy => this.vacancys = vacancy)
  }








}
