import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {UserCompany} from "../home-page/UserCompany";

@Injectable()
export class WorkPageService{
  getMainCompanyUrl : '/api/main/user/authorize/maincompany/?id=';
  getNextMainCompanyUrl: '/api/main/user/authorize/nextmaincompany/?';

  constructor(private http: HttpClient) {
  }

  getMainCompany(id: number): Observable<UserCompany>{
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    return this.http.get<UserCompany>(this.getMainCompanyUrl +id, httpOptions);
  }

  getNextMainNextCompany(id: number, idUserCompany: number): Observable<UserCompany>{
    const urlSearchParams = new URLSearchParams();
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'}).append('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
    };
    urlSearchParams.append("id", id.toString());
    urlSearchParams.append("idPrevCompany", idUserCompany.toString());
    return this.http.get<UserCompany>(this.getNextMainCompanyUrl + urlSearchParams.toString(), httpOptions);

  }

}
