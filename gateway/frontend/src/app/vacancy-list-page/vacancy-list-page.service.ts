import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Vacancy} from './vacancy';
import {VacancySkill} from "./vacancySkill";
import {VacancyListDto} from "./VacancyListDto";


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class VacancyService {
  private countUrl = '/api/main/vacancy/count';
  private userUrl = '/api/main/vacancy/all?';


  constructor(private http: HttpClient) {
  }

  getCountOfVacancy(): Observable<number>{
    return this.http.get<number>(this.countUrl, httpOptions);
  }

  getVacancy(size: number, page: number): Observable<VacancyListDto[]> {
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('size', size.toString());
    urlSearchParams.append('page', page.toString());
    return this.http.get<VacancyListDto[]>(this.userUrl + urlSearchParams.toString(), httpOptions);
  }

}
