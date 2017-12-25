import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from '../shared/service/auth/authentication.service';
import {MyToken} from "./myToken";



@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {

  private username: string;
  private password: string;

  private token: MyToken;


  constructor(private authenticationService: AuthenticationService) {
  }

  ngOnInit() {

  }


  private authenticate(event) {
    this.authenticationService.login(this.username, this.password)
      .subscribe(data => {
        this.token.token = data.access_token;
      });
  }


}
