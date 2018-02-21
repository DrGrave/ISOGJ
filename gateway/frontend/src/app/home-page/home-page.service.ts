import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {MyUser} from "./MyUser";
import {Education} from "./Education";
import {UserCompany} from "./UserCompany";
import {UserSkill} from "../user-list-page/userSkill";
import {UserLink} from "./UserLink";
import {Skill} from "../user-list-page/skill";
import {TypeOfSkill} from "../user-list-page/TypeOfSkill";
import {Gender} from "./Gender";
import {University} from "./University";
import {TypeOfEducation} from "./TypeOfEducation";
import {Department} from "./Department";
import {Faculty} from "./Faculty";
import {Company} from "./Company";
import {Position} from "./Position";
import {User} from "../user-list-page/user";
import {City} from "./City";
import {TypeOfLink} from "./TypeOfLink";


@Injectable()
export class HomePageService {
  private myUserUrl = '/api/auth/users/username';
  private thisUser = '/api/main/user/me/?username=';
  private thisEducationUrl = '/api/main/education/?id=';
  private thisCompanyUrl = '/api/main/company/user/?id=';
  private thisUserSkills = '/api/main/skill/authorize/userskills/?id=';
  private thisUserLinks = '/api/main/user/links/?id=';
  private thisSkillsUrl = '/api/main/skill/add/?name=';
  private thisImg = '/api/main/user/img/?id=';
  private thisAddSkillUrl = '/api/main/skill/authorize/add/?id=';
  private getTypesOfSkillsUrl = '/api/main/skill/authorize/typesofskills';
  private addSkillUrl = '/api/main/skill/authorize/addnew';
  private removeSkillUrl = '/api/main/skill/authorize/delete/?id=';
  private getGenders = '/api/main/gender/authorize/all';
  private changeGenderUrl = '/api/main/user/changegender/?id=';
  private getUniversityByName = '/api/main/university/all/?name=';
  private getTypesOfEducation = '/api/main/education/types';
  private getFacultyUrl = '/api/main/faculty/?name=';
  private getDepartmentUrl = 'api/main/department/?name=';
  private changeEducationUrl = 'api/main/education/change/?id=';
  private addEducationUrl = 'api/main/education/add/?id=';
  private deleteEducationUrl = 'api/main/education/delete/?id=';
  private getCompanysUrl = 'api/main/company/getname/?name=';
  private getPositionsUrl = 'api/main/company/position/getname/?name=';
  private changeCompanyUrl = 'api/main/company/change/?id=';
  private addCompanyUrl = 'api/main/company/add/?id=';
  private deleteCompanyUrl = 'api/main/company/delete/?id=';
  private getCityUrl = 'api/main/city/?name=';
  private applyCityUrl = 'api/main/user/city/?id=';
  private getAllTypesOfLinks = 'api/main/user/links/all';
  private changeLinkUrl = 'api/main/user/links/change/?id=';
  private addLinkUrl = 'api/main/user/links/add/?id=';
  private changeImgUrl = 'api/main/user/links/img/change/?id=';
  private deleteLinkUrl = 'api/main/user/links/delete/?id=';
  private createNewCompanyUrl = 'api/main/company/create/?id=';


  constructor(private http: HttpClient) {
  }

  deleteLink(userLink: UserLink, id: number): Observable<UserLink[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post<UserLink[]>(this.deleteLinkUrl + id, userLink, httpOptions);
  }

  changeImg(userLink: UserLink, id: number): Observable<UserLink>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post<UserLink>(this.changeImgUrl + id, userLink, httpOptions);
  }

  changeLink(userLink: UserLink, id: number): Observable<UserLink[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post<UserLink[]>(this.changeLinkUrl + id, userLink, httpOptions);
  }

  addLink(userLink: UserLink, id: number): Observable<UserLink[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post<UserLink[]>(this.addLinkUrl + id, userLink, httpOptions);
  }

  getUserByToken(): Observable<string> {
    const httpOptions = {
      headers: new HttpHeaders().append('Authorization', 'Bearer ' + localStorage.getItem('access_token')),
      responseType: 'text' as 'json'
    };
    return this.http.get<string>(this.myUserUrl, httpOptions);
  }

  getUserByUsername(username: String): Observable<MyUser>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<MyUser>(this.thisUser + username, httpOptions)
  }

  getEducation(id: number): Observable<Education[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<Education[]>(this.thisEducationUrl + id, httpOptions)
  }

  getMyCompany(id: number): Observable<UserCompany[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<UserCompany[]>( this.thisCompanyUrl + id, httpOptions)
  }

  getMySkills(id: number): Observable<UserSkill[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<UserSkill[]>(this.thisUserSkills + id, httpOptions)
  }

  getUserLinks(id: number): Observable<UserLink[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<UserLink[]>( this.thisUserLinks + id, httpOptions)
  }

  getAddedSkills(nameSkill: string): Observable<Skill[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<Skill[]>( this.thisSkillsUrl + nameSkill, httpOptions);
  }

  getUserImg(id: number) {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<UserLink>(this.thisImg + id, httpOptions);
  }

  addSkill(sellectSkill: Skill, id: number): Observable<UserSkill[]> {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post<UserSkill[]>(this.thisAddSkillUrl + id,sellectSkill , httpOptions);
  }

  getAllTypesOfSkills(): Observable<TypeOfSkill[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<TypeOfSkill[]>(this.getTypesOfSkillsUrl, httpOptions)
  }

  addNewSkill(newSkill: Skill) {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post(this.addSkillUrl,newSkill ,httpOptions)
  }

  removeSkills(id :number, userSkill: UserSkill): Observable<UserSkill[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post<UserSkill[]>(this.removeSkillUrl + id,userSkill, httpOptions);
  }


  getAllGenders():Observable<Gender[]> {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<Gender[]>(this.getGenders, httpOptions);
  }

  changeGender(gender: Gender, id: number): Observable<Gender>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post<Gender>(this.changeGenderUrl + id, gender, httpOptions);
  }

  getUniversitys(name: string): Observable<University[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<University[]>(this.getUniversityByName + name ,httpOptions);
  }

  getAllTypesOfEducation(): Observable<TypeOfEducation[]> {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<TypeOfEducation[]>(this.getTypesOfEducation, httpOptions);
  }

  getDepartments(name: string, faculty: Faculty): Observable<Department[]> {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post<Department[]>(this.getDepartmentUrl, faculty,httpOptions);
  }

  getFaculty(name: string, university: University): Observable<Faculty[]> {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post<Faculty[]>(this.getFacultyUrl, university,httpOptions);
  }

  changeEducation(changedEducation: Education, id: number): Observable<Education[]> {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post<Education[]>(this.changeEducationUrl + id, changedEducation, httpOptions)
  }

  addEducation(education: Education, id: number): Observable<Education[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post<Education[]>(this.addEducationUrl + id, education, httpOptions)
  }

  deleteEducation(educate: Education, id: number): Observable<Education[]> {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post<Education[]>(this.deleteEducationUrl +id, educate, httpOptions);
  }

  getCompanys(name: string): Observable<Company[]> {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<Company[]>(this.getCompanysUrl + name, httpOptions);
  }

  getPositions(name: string): Observable<Position[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<Position[]>(this.getPositionsUrl + name, httpOptions);
  }

  changeCompany(company: UserCompany, id: number): Observable<UserCompany[]> {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post<UserCompany[]>(this.changeCompanyUrl + id, company, httpOptions);
  }

  addCompany(company: UserCompany, id: number): Observable<UserCompany[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post<UserCompany[]>(this.addCompanyUrl +id, company, httpOptions);
  }

  deleteCompany(company: User, id: number): Observable<UserCompany[]>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post<UserCompany[]>(this.deleteCompanyUrl + id, company, httpOptions);
  }

  getCity(name: string): Observable<City[]> {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<City[]>(this.getCityUrl + name, httpOptions);
  }

  addCity(city: City, id: number): Observable<City>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post<City>(this.applyCityUrl + id, city, httpOptions);
  }

  getAllTypesOfLink(): Observable<TypeOfLink[]> {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<TypeOfLink[]>(this.getAllTypesOfLinks, httpOptions);
  }

  createNewCompany(createNewCompany: Company, id: number) :Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.post<any>(this.createNewCompanyUrl + id, createNewCompany, httpOptions);
  }
}


