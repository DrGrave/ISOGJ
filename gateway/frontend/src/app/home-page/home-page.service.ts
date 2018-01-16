import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {MyUser} from "./MyUser";
import {Education} from "./Education";
import {UserCompany} from "./UserCompany";
import {UserSkill} from "../user-list-page/userSkill";
import {UserLink} from "./UserLink";
import {Skill} from "../user-list-page/skill";


@Injectable()
export class HomePageService {
  private myUserUrl = '/api/auth/users/username';
  private thisUser = '/api/main/user/me/?username=';
  private thisEducationUrl = '/api/main/education/?id=';
  private thisCompanyUrl = '/api/main/company/user/?id=';
  private thisUserSkills = '/api/main/skill/authorize/userskills/?id=';
  private thisUserLinks = '/api/main/user/links/?id=';
  private thisSkillsUrl = '/api/main/skill/add/?name=';


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

}
