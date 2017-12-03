import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegPageComponent } from './registration/reg-page.component'
import {UserListPageComponent} from "./user-list-page/user-list-page.component";
import {CompanyListPageComponent} from "./company-list-page/company-list-page.component";

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginPageComponent},
  {path: 'registration', component: RegPageComponent},
  {path: 'login', component: LoginPageComponent},
  {path: 'user-list-page', component: UserListPageComponent},
  {path: 'company-list-page', component: CompanyListPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
