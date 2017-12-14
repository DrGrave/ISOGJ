import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {RegUser} from './reg-user';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable()
export class RegUserPageService {
  private userUrl = '/api/main/user/register';
  private checkLoginUrl = '/api/main/user/checklogin?';
  private checkEmailUrl = '/api/main/user/checkemail?';


  constructor(private http: HttpClient) {
  }


  addRegUser(regUser: RegUser): Observable<any> {
    return this.http.post<RegUser>(this.userUrl, regUser, httpOptions);
  }

  checkLogin(username: string): Observable<boolean> {
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('username', username);
    return this.http.get<boolean>(this.checkLoginUrl + urlSearchParams.toString(), httpOptions);
  }

  checkEmail(regUser: RegUser): Observable<any> {
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('email', regUser.email);
    return this.http.get<boolean>(this.checkEmailUrl + urlSearchParams.toString(), httpOptions);
  }
}
