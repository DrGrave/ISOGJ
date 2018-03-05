import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {FullUserInfo} from "./FullUserInfo";
import {HistorySkills} from "./HistorySkills";
import {Gender} from "./Gender";
import {FormControl} from "@angular/forms";
import {City} from "./City";



@Injectable()
export class HomePageService {
  private thisHistoryCountUrl = '/api/main/user/history/count';
  private thisUser = '/api/main/user/me';
  private thisGetAllGenders = '/api/main/gender/authorize/all';
  private thisHistoryGetPage = '/api/main/user/history/page?';
  private thisChangeGenderUrl = '/api/main/user/changegender?';
  private getCityUrl = 'api/main/city/?name=';
  private changeCityUrl = 'api/main/user/city/change?';





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

  getAllGenders(): Observable<Gender[]>{

    return this.http.get<Gender[]>(this.thisGetAllGenders);
  }

  changeGender(idGender: number): Observable<Gender>{
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('idGender', idGender.toString());
    return this.http.get<Gender>(this.thisChangeGenderUrl + urlSearchParams.toString());
  }

  getCity(name: string): Observable<City[]> {
    return this.http.get<City[]>(this.getCityUrl + name);
  }

  changeCity(cityName: string): Observable<City>{
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('cityName', cityName);
    return this.http.get<City>(this.changeCityUrl + urlSearchParams.toString());
  }
}


