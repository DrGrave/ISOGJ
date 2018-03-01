import {Component, OnInit, ViewChild} from '@angular/core';

import {VacancyService} from './vacancy-list-page.service';
import {Vacancy} from './vacancy';
import {MatPaginator} from "@angular/material";
import {VacancyListDto} from "./VacancyListDto";

@Component({
  selector: 'app-vacancy-list-page',
  templateUrl: './vacancy-list-page.component.html',
  styleUrls: ['./vacancy-list-page.component.scss']
})

export class VacancyListPageComponent implements OnInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  vacancies: Vacancy[];
  vacancyList: VacancyListDto[];
  pageNum: number = 0;
  pageSiz: number = 0;
  vacancyCount: number = 0;


  ngOnInit(): void {
    this.vacancyService.getCountOfVacancy().subscribe( count =>{
      this.vacancyCount = count;
    });
    this.getVacancys(10,0);
  }

  constructor(private vacancyService: VacancyService) {
  }

  getVacancys(size: number, page: number): void {
    this.vacancyService.getVacancy(size, page).subscribe(vacancy => {
      this.vacancyList = vacancy;
    });
  }



  getNextPage(event){
    this.pageNum = this.paginator.pageIndex;
    this.pageSiz = this.paginator.pageSize;
    this.getVacancys(this.pageSiz, this.pageNum);
  }
}
