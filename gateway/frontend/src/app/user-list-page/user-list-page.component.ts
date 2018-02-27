import {Component, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {UserService} from './user-list-page.service';
import {User} from './user';
import {Router} from '@angular/router';
import {MatPaginator} from "@angular/material/paginator";
import {PageEvent} from "@angular/material";
import {UserListInfo} from "./UserListInfo";


@Component({
  selector: 'app-user-list-page',
  templateUrl: './user-list-page.component.html',
  styleUrls: ['./user-list-page.component.scss']
})

export class UserListPageComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  token: string;
  users: User[];
  userList: UserListInfo[];
  user: User;
  selectedUser: User;
  pageNum: number = 0;
  pageSiz: number = 0;
  userCount: number = 0;

  ngOnInit(): void {
    this.getUsers(10, 0);
  }

  constructor(private userService: UserService,
              private router: Router) {
  }

  getUsers(size: number, page: number): void {
    this.userService.getUsersCount().subscribe( count =>{
      this.userCount = count;
    });
    this.userService.getUsers(size,page).subscribe(usersList => {
      this.userList = usersList;
    });
  }


  onSelect(user: User): void {
    if (localStorage.getItem('access_token') != null) {
      this.selectedUser = user;
      this.token = localStorage.getItem('access_token');
      this.router.navigateByUrl('/more-user-info-page?id=' + this.selectedUser.uid);
    }
  }

  getNextPage(event){
    this.pageNum = this.paginator.pageIndex;
    this.pageSiz = this.paginator.pageSize;
    this.getUsers(this.pageSiz, this.pageNum);
  }


}


