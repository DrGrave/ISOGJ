import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpClientModule, HttpHeaders} from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.scss']
})
export class MainPageComponent implements OnInit {

  private username: string;
  private password: string;
  private token: String;



  constructor(private http: HttpClient) { }

  ngOnInit() {

  }


  private authenticate(event) {
      this.login(this.username, this.password)
        .subscribe(data => this.token = data.access_token);
  }

  public login(username: string, password: string): Observable<any> {
    let urlSearchParams = new URLSearchParams();

    urlSearchParams.append('grant_type', 'password');
    urlSearchParams.append('username', username);
    urlSearchParams.append('password', password);

    return this.getTokens(urlSearchParams.toString());
  }

  private getTokens(urlParameters: string): Observable<any> {
    return this.http.post('/auth/oauth/token?' + urlParameters, null, {headers: this.getLoginHeader()});
  }



  private getLoginHeader() {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    headers = headers.append("Authorization", "Basic " + btoa("browser:"));
    console.log(headers);
    return headers;
  }

}
