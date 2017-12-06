import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {RegUser} from "./reg-user";



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable()
export class RegUserPageService {
  private userUrl = "/main/user/register";
  private checkLoginkUrl = "/main/user/checklogin?";
  private checkEmailUrl = "/main/user/checkemail?";


  constructor(private http: HttpClient) {
  }


  addRegUser(regUser : RegUser): Observable<any> {
    return this.http.post<RegUser>(this.userUrl, regUser, httpOptions)
  }

  checkLogin(regUser: RegUser): Observable<any> {
      let urlSearchParams = new URLSearchParams();
      urlSearchParams.append('username', regUser.username);
      return this.http.get(this.checkLoginkUrl + urlSearchParams.toString(), httpOptions);
  }

  checkEmail(regUser: RegUser): Observable<any>{
      let urlSearchParams = new URLSearchParams();
      urlSearchParams.append('email', regUser.email);
      return this.http.get(this.checkEmailUrl + urlSearchParams.toString(), httpOptions);
  }
}
