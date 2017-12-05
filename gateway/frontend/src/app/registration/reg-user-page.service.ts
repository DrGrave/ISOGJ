import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {RegUser} from "./reg-user";
import {isUndefined} from "util";
import {validate} from "codelyzer/walkerFactory/walkerFn";


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable()
export class RegUserPageService {
  private userUrl = "/main/registration";
  private checkLoginkUrl = "/main/checklogin?";
  private checkEmailUrl = "/main/checkemail?";


  constructor(private http: HttpClient) {
  }


  addRegUser(regUser : RegUser): Observable<any> {
    return this.http.post<RegUser>(this.userUrl, regUser, httpOptions)
  }

  checkLogin(regUser: RegUser): Observable<any> {
      let urlSearchParams = new URLSearchParams();
      urlSearchParams.append('email', regUser.username);
      return this.http.post(this.checkLoginkUrl + urlSearchParams.toString(), null, httpOptions)
  }

  checkEmail(regUser: RegUser): Observable<any>{
      let urlSearchParams = new URLSearchParams();
      urlSearchParams.append('username', regUser.email);
      return this.http.post(this.checkEmailUrl + urlSearchParams.toString(), null, httpOptions);
  }
}
