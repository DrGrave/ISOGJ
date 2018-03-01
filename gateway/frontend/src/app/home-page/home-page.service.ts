import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {MyUser} from "./MyUser";
import {UserLink} from "./UserLink";



@Injectable()
export class HomePageService {
  private thisUser = '/api/main/user/me';
  private imageUrl = '/api/main/user/img';


  constructor(private http: HttpClient) {
  }


  getUser(): Observable<MyUser>{
    return this.http.get<MyUser>(this.thisUser);
  }

  getUserImage(): Observable<UserLink> {
    return this.http.get<UserLink>(this.imageUrl);
  }
}


