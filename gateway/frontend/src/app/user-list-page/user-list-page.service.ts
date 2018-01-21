import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {User} from './user';
import {UserSkill} from "./userSkill";
import {UserLink} from "../home-page/UserLink";
import {EducationDto} from "./EducationDto";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class UserService {
  private userUrl = '/api/main/user/all';
  private skillUrl = '/api/main/skill/userskills?';
  private thisImg = '/api/main/user/userlistimg/?id=';
  private getUserAducUrl = '/api/main/education/userlist/?id=';



  constructor(private http: HttpClient) {
  }


  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl);
  }

  getSkills(id :number): Observable<UserSkill[]>{
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('id', id.toString());
    return this.http.get<UserSkill[]>(this.skillUrl + urlSearchParams.toString(), httpOptions);
  }

  getUserImg(id: number) {
    return this.http.get<UserLink>(this.thisImg + id, httpOptions);
  }

  getUserAducation(id: number): Observable<EducationDto>{
    return this.http.get<EducationDto>(this.getUserAducUrl + id, httpOptions);
  }
}
