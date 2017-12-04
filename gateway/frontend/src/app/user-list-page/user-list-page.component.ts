

import {Component, OnInit} from "@angular/core";
import {UserService} from "./user-list-page.service";
import {User} from "./user";

@Component({
  selector: 'app-user-list-page',
  templateUrl: './user-list-page.component.html',
  styleUrls: ['./user-list-page.component.scss']
})

export class UserListPageComponent implements OnInit{

  ngOnInit(): void {
    this.getUsers()
  }

  constructor(private userService: UserService){}
  users : User[];

  getUsers(): void{
    this.userService.getUsers().subscribe(users => this.users = users)
  }

}

