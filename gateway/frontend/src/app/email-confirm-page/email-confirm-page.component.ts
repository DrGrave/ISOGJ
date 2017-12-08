import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router, RouterModule} from "@angular/router";
import {Subscription} from "rxjs/Subscription";
import {EmailConfimPageService} from "./email-confim-page.service";
import {AppRoutingModule} from "../app-routing.module";




@Component({
  selector: 'app-email-confirm-page',
  templateUrl: './email-confirm-page.component.html',
  styleUrls: ['./email-confirm-page.component.scss']
})
export class EmailConfirmPageComponent implements OnInit {

  private id: number;
  private ifOk: boolean;
  private error: string;

  private routeSubscription: Subscription;
  private querySubscription: Subscription;
  myLink : string;
  constructor(private activateRoute :ActivatedRoute, private emailConfService :EmailConfimPageService, private router: Router) {
    this.routeSubscription = activateRoute.params.subscribe(params=>this.id=params['id']);
    this.querySubscription = activateRoute.queryParams.subscribe(
      (queryParam: any) => {
        this.myLink = queryParam['link'];
      }
    );
  }

  ngOnInit() {
    this.emailConfService.sendLink(this.myLink).subscribe(data => this.ifOk = data);
    if (this.ifOk == true){
      this.router.navigateByUrl("/login");
    } else {
      this.error = 'Error in token';
    }

  }
}
