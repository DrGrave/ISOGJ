import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs/Subscription";
import {ActivatedRoute} from "@angular/router";
import {MoreUserInfoPageService} from "./more-user-info-page-service";
import {UserMoreInfo} from "./UserMoreInfo";

@Component({
  selector: 'app-more-user-info-page',
  templateUrl: './more-user-info-page.component.html',
  styleUrls: ['./more-user-info-page.component.scss']
})
export class MoreUserInfoPageComponent implements OnInit {
  private id: number;
  private querySubscription: Subscription;
  private moreUserInfo: UserMoreInfo;
  constructor(private activateRoute: ActivatedRoute, private moreInfoService: MoreUserInfoPageService) {

    this.querySubscription = activateRoute.queryParams.subscribe(
      (queryParam: any) => {
        this.id = queryParam['id'];
      }
    );
  }

  ngOnInit() {
    this.moreInfoService.getMoreInfoToUser(this.id).subscribe(date => this.moreUserInfo = date);
  }

}
