import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class AuthenticationService {

  constructor(private http: HttpClient,
              private router: Router) {
  }


  public login(username: string, password: string): Observable<any> {
    const urlSearchParams = new URLSearchParams();

    urlSearchParams.append('grant_type', 'password');
    urlSearchParams.append('username', username);
    urlSearchParams.append('password', password);

    return this.getTokens(urlSearchParams.toString());
  }

  private getTokens(urlParameters: string): Observable<any> {
    return this.http.post('/api/auth/oauth/token?' + urlParameters, null, {headers: this.getLoginHeader()});
  }


  private getLoginHeader() {
    let headers = new HttpHeaders({'Content-Type': 'application/json'});

    headers = headers.append('Authorization', 'Basic ' + btoa('browser:'));
    return headers;
  }


}
