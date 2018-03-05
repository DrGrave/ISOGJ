import {Component, OnInit, ViewChild} from '@angular/core';
import {HomePageService} from './home-page.service';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {MatDatepickerInputEvent, MatPaginator} from "@angular/material";
import {FullUserInfo} from "./FullUserInfo";
import {Gender} from "./Gender";



@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  myUser: FullUserInfo;
  username: string;
  genders: Gender[];
  pageNum: number = 0;
  pageSiz: number = 0;
  historyCount: number = 0;
  ifChangeGenderClick: boolean = false;
  selectedGender;





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
      this.getGenders();
      this.selectedGender = data.meUserDto.gender;
      localStorage.setItem('myUser', JSON.stringify(this.myUser))
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

  private getGenders(){
    this.homePageService.getAllGenders().subscribe( date => {
      this.genders = date;
      this.selectedGender = this.myUser.meUserDto.gender.id;
    });
  }

  changeGenderAction() {

    this.ifChangeGenderClick = !this.ifChangeGenderClick;
  }


  changeGenderApply() {
    this.ifChangeGenderClick = !this.ifChangeGenderClick;
    if (this.myUser.meUserDto.gender.id != this.selectedGender) {
      this.homePageService.changeGender(this.selectedGender).subscribe();
    }
  }
}


