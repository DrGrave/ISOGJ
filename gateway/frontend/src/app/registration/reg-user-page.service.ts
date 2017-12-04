import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {RegUser} from "./reg-user";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable()
export class RegUserPageService {
  private userUrl = "/main/registration";


  constructor(private http: HttpClient) {
  }


  addRegUser(regUser : RegUser): Observable<any> {
    return this.http.post<RegUser>(this.userUrl, regUser, httpOptions)
  }
}
