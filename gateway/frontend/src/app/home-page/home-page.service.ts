import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {MyUser} from "./MyUser";
import {UserLink} from "./UserLink";
import {FullUserInfo} from "./FullUserInfo";



@Injectable()
export class HomePageService {
  private thisUser = '/api/main/user/me';


  constructor(private http: HttpClient) {
  }


  getUser(): Observable<FullUserInfo>{
    return this.http.get<FullUserInfo>(this.thisUser);
  }
}


