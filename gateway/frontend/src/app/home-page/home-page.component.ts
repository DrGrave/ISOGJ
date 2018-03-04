import {Component, OnInit, ViewChild} from '@angular/core';
import {HomePageService} from './home-page.service';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {MatDatepickerInputEvent, MatPaginator} from "@angular/material";
import {FullUserInfo} from "./FullUserInfo";



@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  myUser: FullUserInfo;
  username: string;
  pageNum: number = 0;
  pageSiz: number = 0;
  historyCount: number = 0;






  constructor(private homePageService: HomePageService, private router: Router, private fb: FormBuilder) {
  }


  ngOnInit() {
    this.getMyAccount();
  }

  getMyAccount(){
    this.homePageService.getSizeHistory().subscribe(date =>{
      this.historyCount = date;
    });
    this.homePageService.getUser().subscribe( data => {
      this.myUser = data;
      localStorage.setItem('myUser', JSON.stringify(this.myUser));
    });
  }

  getNextPage(event){
    this.pageNum = this.paginator.pageIndex;
    this.pageSiz = this.paginator.pageSize;
    this.getNextHistory(this.pageSiz, this.pageNum);
  }

  private getNextHistory(pageSiz: number, pageNum: number) {
    this.homePageService.getHistory(this.pageNum,this.pageSiz).subscribe(date => {
      this.myUser.historySkillsDtoList = date;
    });
  }
}


