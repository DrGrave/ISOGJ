import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Vacancy} from './vacancy';


@Injectable()
export class VacancyService {
  private userUrl = '/api/main/vacancy/all';


  constructor(private http: HttpClient) {
  }


  getVacancy(): Observable<Vacancy[]> {
    return this.http.get<Vacancy[]>(this.userUrl);
  }

}
