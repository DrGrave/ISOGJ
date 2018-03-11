import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {FullUserInfo} from "./FullUserInfo";
import {HistorySkills} from "./HistorySkills";
import {Gender} from "./Gender";
import {City} from "./City";
import {TypeOfEducation} from "./TypeOfEducation";
import {University} from "./University";
import {Faculty} from "./Faculty";
import {Department} from "./Department";
import {Education} from "./Education";
import {EducationSkillsDto} from "./EducationSkillsDto";



@Injectable()
export class HomePageService {
  private thisHistoryCountUrl = '/api/main/user/history/count';
  private thisUser = '/api/main/user/me';
  private thisGetAllGenders = '/api/main/gender/authorize/all';
  private thisHistoryGetPage = '/api/main/user/history/page?';
  private thisChangeGenderUrl = '/api/main/user/changegender?';
  private getCityUrl = 'api/main/city/?name=';
  private changeCityUrl = 'api/main/user/city/change?';
  private getTypesOfEducationUrl = 'api/main/education/types';
  private universityUrl = 'api/main/university/all?';
  private getFacultyUrl = '/api/main/faculty?';
  private getDepartmentUrl = 'api/main/department?';
  private addEducationUrl = 'api/main/education/add';





  constructor(private http: HttpClient) {
  }


  getUser(): Observable<FullUserInfo>{

    return this.http.get<FullUserInfo>(this.thisUser);
  }

  getSizeHistory(): Observable<number> {
    return this.http.get<number>(this.thisHistoryCountUrl);
  }

  getHistory(page: number, size: number): Observable<HistorySkills[]>{
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('page', page.toString());
    urlSearchParams.append('size', size.toString());
    return this.http.get<HistorySkills[]>(this.thisHistoryGetPage + urlSearchParams.toString());
  }

  getAllGenders(): Observable<Gender[]>{

    return this.http.get<Gender[]>(this.thisGetAllGenders);
  }

  changeGender(idGender: number): Observable<Gender>{
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('idGender', idGender.toString());
    return this.http.get<Gender>(this.thisChangeGenderUrl + urlSearchParams.toString());
  }

  getCity(name: string): Observable<City[]> {
    return this.http.get<City[]>(this.getCityUrl + name);
  }

  changeCity(cityName: string): Observable<City>{
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('cityName', cityName);
    return this.http.get<City>(this.changeCityUrl + urlSearchParams.toString());
  }
  getAllTypesOfEducation(): Observable<TypeOfEducation[]> {
    return this.http.get<TypeOfEducation[]>(this.getTypesOfEducationUrl);
  }

  getUniversity(name: string): Observable<University[]>{
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('name', name);
    return this.http.get<University[]>( this.universityUrl + urlSearchParams.toString());
  }

  getFaculty(name: string, university: University): Observable<Faculty[]> {
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('name', name);
    return this.http.post<Faculty[]>(this.getFacultyUrl + urlSearchParams.toString(), university);
  }

  getDepartments(name: string, faculty: Faculty): Observable<Department[]> {
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('name', name);
    return this.http.post<Department[]>(this.getDepartmentUrl + urlSearchParams.toString(), faculty);
  }

  addEducation(education: Education): Observable<EducationSkillsDto[]>{
    return this.http.post<EducationSkillsDto[]>(this.addEducationUrl, education);
  }

}


