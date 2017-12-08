

import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class EmailConfimPageService{
  private url = "http://localhost:3001/api/main/user/?link="

  constructor(private http: HttpClient){}
  sendLink(link :string):Observable<any>{
    return this.http.get(this.url+link, httpOptions)
  }
}
