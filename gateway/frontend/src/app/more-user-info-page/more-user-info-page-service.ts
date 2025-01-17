import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {UserMoreInfo} from './UserMoreInfo';


@Injectable()
export class MoreUserInfoPageService {
  private infoUrl = '/api/main/user/moreuserinfo?';



  constructor(private http: HttpClient) {
  }


  getMoreInfoToUser(id: number): Observable<UserMoreInfo> {
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('id', id.toString());

    return this.http.get<UserMoreInfo>(this.infoUrl + urlSearchParams.toString());

  }
}
