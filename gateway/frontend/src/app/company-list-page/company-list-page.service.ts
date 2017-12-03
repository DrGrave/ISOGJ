import {User} from "./user";

import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService{
  private userUrl = "/main/user/all";

  constructor(
    private http: HttpClient
  ){}


  getUsers (): Observable<User[]>{
      return this.http.get<User[]>(this.userUrl)
  }

}
