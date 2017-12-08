import {Component, OnInit} from '@angular/core';
import {User} from '../user-list-page/user';
import {VacancyService} from './vacancy-list-page.service';
import {Vacancy} from './vacancy';

@Component({
  selector: 'app-vacancy-list-page',
  templateUrl: './vacancy-list-page.component.html',
  styleUrls: ['./vacancy-list-page.component.scss']
})

export class VacancyListPageComponent implements OnInit {

  vacancies: Vacancy[];

  ngOnInit(): void {
    this.getVacancys();
  }

  constructor(private vacancyService: VacancyService) {
  }

  getVacancys(): void {
    this.vacancyService.getVacancy().subscribe(vacancy => this.vacancies = vacancy);
  }


}
