import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from '../shared/service/auth/authentication.service';

import {Router} from "@angular/router";



@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {

  private username: string;
  private password: string;
  private error: string;

  private token: string;


  constructor(private authenticationService: AuthenticationService, private router: Router) {
  }

  ngOnInit() {

  }


  private authenticate(event) {
    this.authenticationService.login(this.username, this.password)
      .subscribe(data => {
        this.token = data.access_token;
        this.router.navigateByUrl("/home-page");
      });
  }


}
