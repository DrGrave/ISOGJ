

import {Component, OnInit} from "@angular/core";
import {UserService} from "./user-list-page.service";
import {User} from "./user";
import {forEach} from "@angular/router/src/utils/collection";
import {UserSkill} from "./userSkill";

@Component({
  selector: 'app-user-list-page',
  templateUrl: './user-list-page.component.html',
  styleUrls: ['./user-list-page.component.scss']
})

export class UserListPageComponent implements OnInit{

  ngOnInit(): void {
    this.getUsers();

  }

  constructor(private userService: UserService){}
  users : User[]  ;
  skills: UserSkill[];
  user: User;
  selectedUser: User;

  getUsers(): void{
    this.userService.getUsers().subscribe(usersList => {
      this.users = usersList;
      this.getAllSkills();
    });
  }

  getAllSkills(){
   for (let i = 0; i < this.users.length; i++){
     this.userService.getSkills(this.users[i].id).subscribe( skills => this.users[i].skill = skills);
   }
  }

  onSelect(user: User): void {
    this.userService.getSkills(user.id).subscribe( skills => user.skill = skills);
    this.selectedUser = user;
  }


}

