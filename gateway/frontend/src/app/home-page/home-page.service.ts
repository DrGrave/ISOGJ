import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {MyUser} from "./MyUser";
import {UserLink} from "./UserLink";



const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
};

@Injectable()
export class HomePageService {
  private myUserUrl = '/api/auth/users/username';
  private thisUser = '/api/main/user/me';
  private imageUrl = '/api/main/user/img';


  constructor(private http: HttpClient) {
  }

  getUserByToken(): Observable<string> {
    const httpOptions = {
      headers: new HttpHeaders().append('Authorization', 'Bearer ' + localStorage.getItem('access_token')),
      responseType: 'text' as 'json'
    };
    return this.http.get<string>(this.myUserUrl, httpOptions);
  }

  getUser(): Observable<MyUser>{
    return this.http.get<MyUser>(this.thisUser, httpOptions);
  }

  getUserImage(): Observable<UserLink> {
    return this.http.get<UserLink>(this.imageUrl, httpOptions);
  }
}


