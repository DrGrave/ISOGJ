import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';

import {AppComponent} from './app.component';
import {LoginPageComponent} from './login-page/login-page.component';
import {RegPageComponent} from './registration/reg-page.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule, /*FormControl, Validators*/} from '@angular/forms';
import {MatButtonModule, MatInputModule, MatToolbarModule} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {SharedModule} from './shared/shared.module';
import {AuthenticationService} from './shared/service/auth/authentication.service';
import {UserListPageComponent} from "./user-list-page/user-list-page.component";
import {CompanyListPageComponent} from "./vacancy-list-page/vacancy-list-page.component";
import {VacancyService} from "./vacancy-list-page/vacancy-list-page.service";
import {UserService} from "./user-list-page/user-list-page-service";


@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    UserListPageComponent,
    CompanyListPageComponent,
    LoginPageComponent,
    RegPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatInputModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatButtonModule,
    SharedModule,
    MatToolbarModule
  ],
  providers: [
    VacancyService,
    AuthenticationService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
