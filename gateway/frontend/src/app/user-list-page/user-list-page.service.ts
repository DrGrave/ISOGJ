import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {User} from './user';
import {UserSkill} from "./userSkill";
import {UserLink} from "../home-page/UserLink";
import {EducationDto} from "./EducationDto";
import {UserListInfo} from "./UserListInfo";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class UserService {
  private countUrl = '/api/main/user/count';
  private userUrl = '/api/main/user/all?';
  private skillUrl = '/api/main/skill/userskills?';
  private thisImg = '/api/main/user/userlistimg?';
  private getUserAducUrl = '/api/main/education/userlist?';



  constructor(private http: HttpClient) {
  }

  getUsersCount(): Observable<number>{
    return this.http.get<number>(this.countUrl, httpOptions);
  }

  getUsers(size: number, page: number): Observable<UserListInfo[]> {
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('page', page.toString());
    urlSearchParams.append('size', size.toString());
    return this.http.get<UserListInfo[]>(this.userUrl + urlSearchParams.toString(), httpOptions);
  }


  getUserImg(id: String) {
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('id', id.toString());
    return this.http.get<UserLink>(this.thisImg + urlSearchParams.toString(), httpOptions);
  }

  getUserAducation(id: String): Observable<EducationDto[]>{
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('id', id.toString());
    return this.http.get<EducationDto[]>(this.getUserAducUrl + urlSearchParams.toString(), httpOptions);
  }
}
