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
import {Company} from "./Company";
import {SkillsToPosition} from "./SkillsToPosition";
import {Skill} from "../user-list-page/skill";


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
  private deleteEucationUrl = 'api/main/education/delete?';
  private changeEducationUrl = 'api/main/education/change';
  private getCompanysUrl = 'api/main/company/get?';
  private getPositionUrl = 'api/main/company/position/get?';
  private getSkillPartNameUrl = 'api/main/skill/getbypartname?';
  private saveSkillUrl = 'api/main/company/position/skill/save?';
  private savePositionUrl = 'api/main/company/position/savenew?';



  constructor(private http: HttpClient) {
  }

  getPositions(company: number, name: string): Observable<SkillsToPosition[]>{
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('name', name);
    urlSearchParams.append('companyId', company.toString());
    return this.http.get<SkillsToPosition[]>(this.getPositionUrl + urlSearchParams.toString())
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

  getCompanys(name: string): Observable<Company[]>{
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('name', name);
    return this.http.get<Company[]>(this.getCompanysUrl + urlSearchParams.toString());
  }

  changeEducation(education: Education): Observable<EducationSkillsDto[]>{
    return this.http.post<EducationSkillsDto[]>(this.changeEducationUrl, education);
  }

  getDepartments(name: string, faculty: Faculty): Observable<Department[]> {
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('name', name);
    return this.http.post<Department[]>(this.getDepartmentUrl + urlSearchParams.toString(), faculty);
  }

  addEducation(education: Education): Observable<EducationSkillsDto[]>{
    return this.http.post<EducationSkillsDto[]>(this.addEducationUrl, education);
  }

  getSkillsByPartName(name: string): Observable<Skill[]>{
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('name', name);
    return this.http.get<Skill[]>(this.getSkillPartNameUrl + urlSearchParams.toString());

  }

  deleteEducate(educate: Education): Observable<EducationSkillsDto[]>{
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('educateId', educate.id.toString());
    return this.http.get<EducationSkillsDto[]>(this.deleteEucationUrl + urlSearchParams.toString());
  }

  addNewSkill(skill: string): Observable<Skill>{
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('skillName', skill.toString());
    return this.http.get<Skill>(this.saveSkillUrl + urlSearchParams.toString());
  }

  saveNewPosition(name: string){
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('positionName', name.toString());
    return this.http.get<SkillsToPosition>(this.savePositionUrl + urlSearchParams.toString());
  }

}


