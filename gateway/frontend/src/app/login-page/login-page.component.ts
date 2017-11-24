import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AuthenticationService} from '../shared/service/auth/authentication.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {

  private username: string;
  private password: string;
  private token: String;



  constructor(private authenticationService: AuthenticationService) { }

  ngOnInit() {

  }


  private authenticate(event) {
      this.authenticationService.login(this.username, this.password)
        .subscribe(data => this.token = data.access_token);
  }



}
