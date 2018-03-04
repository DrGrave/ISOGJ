import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {FullUserInfo} from "./FullUserInfo";
import {HistorySkills} from "./HistorySkills";



@Injectable()
export class HomePageService {
  private thisHistoryCountUrl = '/api/main/user/history/count';
  private thisUser = '/api/main/user/me?';
  private thisHistoryGetPage = '/api/main/user/history/page?';


  constructor(private http: HttpClient) {
  }


  getUser(): Observable<FullUserInfo>{

    return this.http.get<FullUserInfo>(this.thisUser);
  }

  getSizeHistory(): Observable<number> {
    return this.http.get<number>(this.thisHistoryCountUrl);
  }

  getHistory(page: number, size: number): Observable<HistorySkills[]>{
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('page', page.toString());
    urlSearchParams.append('size', size.toString());
    return this.http.get<HistorySkills[]>(this.thisHistoryGetPage + urlSearchParams.toString());
  }
}


