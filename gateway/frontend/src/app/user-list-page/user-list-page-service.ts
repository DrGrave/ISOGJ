import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {User} from "./user";




@Injectable()
export class UserService {
  private userUrl = "/main/user/all";


  constructor(private http: HttpClient) {
  }


  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl)
  }
}
