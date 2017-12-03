

import {Component, OnInit} from "@angular/core";
import {User} from "./user";
import {UserService} from "./company-list-page.service";

@Component({
  selector: 'app-company-list-page',
  templateUrl: './company-list-page.component.html',
  styleUrls: ['./company-list-page.component.scss']
})

export class CompanyListPageComponent implements OnInit{
  ngOnInit(): void {

  }

  constructor(private userService: UserService){}

  users : User[];

  getUsers(): void{
      this.userService.getUsers().subscribe(users => this.users = users)
  }




}
