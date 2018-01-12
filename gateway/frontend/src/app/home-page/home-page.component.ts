import {Component, OnInit} from '@angular/core';
import {HomePageService} from './home-page.service';
import {MyUser} from './MyUser';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  myUser: MyUser;
  username: string;

  constructor(private homePageService: HomePageService) {

  }

  ngOnInit() {
    this.homePageService.getUserByToken().subscribe(data => {
      this.username = data;
      this.getMyAccaunt()
    });
  }


  getMyAccaunt(){
    this.homePageService.getUserByUsername(this.username).subscribe( data => this.myUser = data);
  }
}
