import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Vacancy} from './vacancy';
import {Skill} from "../user-list-page/skill";
import {VacancySkill} from "./vacancySkill";


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class VacancyService {
  private userUrl = '/api/main/vacancy/all';
  private skillUrl = '/api/main/skill/vacancyskills?';


  constructor(private http: HttpClient) {
  }


  getVacancy(): Observable<Vacancy[]> {
    return this.http.get<Vacancy[]>(this.userUrl);
  }

  getSkills(idVacancy: number):Observable<VacancySkill[]>{
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('id', idVacancy.toString());
    return this.http.get<VacancySkill[]>(this.skillUrl + urlSearchParams.toString(), httpOptions)
  }
}
