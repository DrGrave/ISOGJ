import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {UserCompany} from "../home-page/UserCompany";


@Injectable()
export class CompanyPageService {
  private getMainCompanyUrl = '/api/main/company/authorize/maincompany/?id=';
  private getNextMainCompanyUrl = '/api/main/company/authorize/nextmaincompany/?';


  constructor(private http: HttpClient) {
  }


  getMainCompany(id: number): Observable<UserCompany> {
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
