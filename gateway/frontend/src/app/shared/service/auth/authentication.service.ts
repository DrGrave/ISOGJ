import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/do';
import {SinginUser} from "./SinginUser";
import {BehaviorSubject} from "rxjs/BehaviorSubject";


@Injectable()
export class AuthenticationService {

  constructor(private http: HttpClient,
              private router: Router) {
  }
  private loggedIn = new BehaviorSubject<boolean>(false);

  public login(user :SinginUser): Observable<any> {
    const urlSearchParams = new URLSearchParams();

    urlSearchParams.append('grant_type', 'password');
    urlSearchParams.append('username', user.username);
    urlSearchParams.append('password', user.password);

    return this.getTokens(urlSearchParams.toString())
      .do(data => {
        if (data.access_token) {
          localStorage.setItem('access_token', data.access_token);
        }
        if (data.refresh_token) {
          localStorage.setItem('refresh_token', data.refresh_token);
        }
        this.loggedIn.next(true);
      });
  }

  get isLoggedIn() {
    return this.loggedIn.asObservable(); // {2}
  }

  private getTokens(urlParameters: string): Observable<any> {
    return this.http.post('/api/auth/oauth/token?' + urlParameters, null, {headers: this.getLoginHeader()});
  }

  private getLoginHeader() {
    let headers = new HttpHeaders({'Content-Type': 'application/json'});

    headers = headers.append('Authorization', 'Basic ' + btoa('browser:'));
    return headers;
  }

  logout() {                            // {4}
    this.loggedIn.next(false);
    this.router.navigate(['/login']);
  }

}
