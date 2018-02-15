import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {UserCompany} from "../home-page/UserCompany";
import {User} from "../user-list-page/user";
import {Vacancy} from "../vacancy-list-page/vacancy";
import {VacancyTask} from "./VacancyTask";
import {UserWork} from "./UserWork";


@Injectable()
export class CompanyPageService {
  private getMainCompanyUrl = '/api/main/company/authorize/maincompany/?id=';
  private getNextMainCompanyUrl = '/api/main/company/authorize/nextmaincompany/?';
  private getUsersToCompanyUrl = '/api/main/company/authorize/users/?id=';
  private getNotUsersToCompanyUrl = '/api/main/company/authorize/notappusers/?id=';
  private getVacancysUrl = '/api/main/company/authorize/vacancys/?id=';
  private getUsersToVacancy = '/api/main/vacancy/authorize/user?id=';
  private getNotUsersToVacancy = '/api/main/vacancy/authorize/nuser?id=';
  private getTasksUrl = '/api/main/vacancy/authorize/task/?id=';
  private getUserPositionUrl = '/api/main/company/user/position/?';



  constructor(private http: HttpClient) {
  }


  getMainCompany(id: number): Observable<UserCompany> {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<UserCompany>(this.getMainCompanyUrl +id, httpOptions);
  }

  getNextMainNextCompany(id: number, idUserCompany: number): Observable<UserCompany>{
    const urlSearchParams = new URLSearchParams();
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    urlSearchParams.append("id", id.toString());
    urlSearchParams.append("idPrevCompany", idUserCompany.toString());
    return this.http.get<UserCompany>(this.getNextMainCompanyUrl + urlSearchParams.toString(), httpOptions);

  }

  getUsersToCompany(id: number): Observable<UserWork[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<UserWork[]>(this.getUsersToCompanyUrl + id, httpOptions);
  }

  getNotUsersToCompany(id: number): Observable<UserWork[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<UserWork[]>(this.getNotUsersToCompanyUrl + id, httpOptions);
  }

  getVacancys(id: number): Observable<Vacancy[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<Vacancy[]>(this.getVacancysUrl + id, httpOptions);
  }

  getVacancysUser(id: number): Observable<User[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<User[]>(this.getUsersToVacancy + id, httpOptions);
  }

  getVacancysNotUser(id: number): Observable<User[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<User[]>(this.getNotUsersToVacancy + id, httpOptions);
  }

  getVacancyTask(id: number): Observable<VacancyTask[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<VacancyTask[]>(this.getTasksUrl + id, httpOptions);
  }

  getUserPosition(idUser: number, idCompany: number): Observable<UserCompany>{
    const urlSearchParams = new URLSearchParams();
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    urlSearchParams.append("idUser", idUser.toString());
    urlSearchParams.append("idCompany", idCompany.toString());
    return this.http.get<UserCompany>(this.getUserPositionUrl + urlSearchParams.toString(), httpOptions)
  }

}
