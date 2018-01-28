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


  constructor(private http: HttpClient) {
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
}


