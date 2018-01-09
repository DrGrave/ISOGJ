import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';


@Injectable()
export class HomePageService {
  private myUserUrl = '/api/auth/users/username';

  private httpOptions = {
    headers: new HttpHeaders().append('Authorization', 'Bearer ' + localStorage.getItem('access_token')),
    responseType: 'text'
  };

  constructor(private http: HttpClient) {
  }


  getUserByToken(): Observable<string> {
    return this.http.get<string>(this.myUserUrl, this.httpOptions);
  }
}
