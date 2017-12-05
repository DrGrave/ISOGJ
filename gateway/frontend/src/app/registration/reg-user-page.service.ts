import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {RegUser} from "./reg-user";
import {RegUserCheck} from "./reg-user-check";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable()
export class RegUserPageService {
  private userUrl = "/main/registration";
  private checkUrl = "/main/usercheck";
  regUserCheck : RegUserCheck = new RegUserCheck;

  constructor(private http: HttpClient) {
  }


  addRegUser(regUser : RegUser): Observable<any> {
    return this.http.post<RegUser>(this.userUrl, regUser, httpOptions)
  }

  checkLogin(regUser: RegUser): Observable<any> {
    this.regUserCheck.username = regUser.username;
    this.regUserCheck.email = regUser.email;

    return this.http.post<RegUserCheck>(this.checkUrl, this.regUserCheck, httpOptions)
  }
}
