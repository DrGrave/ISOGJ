import {Component, OnInit, ViewChild} from '@angular/core';
import {HomePageService} from './home-page.service';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {MatDatepickerInputEvent, MatPaginator, MatIconRegistry} from "@angular/material";
import {FullUserInfo} from "./FullUserInfo";
import {DomSanitizer} from "@angular/platform-browser";



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
  ifChangeGenderClick: boolean = false;

  genderChangeGroup: FormGroup;

  genderForm: FormGroup;




  constructor(private homePageService: HomePageService, private router: Router, private fb: FormBuilder, iconRegistry: MatIconRegistry, sanitizer: DomSanitizer) {
    this.genderChangeGroup = new FormGroup({
      genderChangeControl: new FormControl()
    });
  }


  ngOnInit() {
    this.genderForm = this.fb.group({
      gender: ['', Validators.required]
    });
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

  changeGenderAction() {
    this.ifChangeGenderClick = !this.ifChangeGenderClick;
  }
}


