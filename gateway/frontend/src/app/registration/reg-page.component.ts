import {Component, OnInit} from '@angular/core';
import {RegUser} from './reg-user';
import {RegUserPageService} from './reg-user-page.service';
import {
  AbstractControl, FormControl, FormGroup, FormGroupDirective, NgForm, NgModel, ValidationErrors,
  Validators
} from '@angular/forms';
import {Router} from '@angular/router';
import {logger} from 'codelyzer/util/logger';
import {ErrorStateMatcher} from '@angular/material';
import {Observable} from 'rxjs/Observable';
import {HttpClient} from '@angular/common/http';
import {Subject} from 'rxjs/Subject';


@Component({
  selector: 'app-reg-page',
  templateUrl: './reg-page.component.html',
  styleUrls: ['./reg-page.component.scss']
})

export class RegPageComponent implements OnInit {

  constructor(private registerService: RegUserPageService, private router: Router) {
  }
  ifRegisterOk: boolean;
  regUser: RegUser = new RegUser;
  secPass: string;
  matcher = new MyErrorStateMatcher();

  regFormGroup: FormGroup;
  passwordPattern = '^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{8,}$';


  ngOnInit(): void {
    this.regFormGroup = new FormGroup({
      username: new FormControl('', {
        validators: [Validators.required, Validators.pattern('^[a-zA-Z]+$')],
        asyncValidators: [this.uniqueLoginValidator.bind(this)]
        }),
      password: new FormControl('',
        [Validators.required, Validators.pattern(this.passwordPattern)]),
      confirmPassword: new FormControl('',
        [Validators.required, Validators.pattern(this.passwordPattern)]),
      email: new FormControl('',
        [Validators.required, Validators.email]),
      firstName: new FormControl('',
        [Validators.required]),
      middleName: new FormControl('',
        [Validators.required]),
      lastName: new FormControl('',
        [Validators.required])
    });


  }

  private regMyUser() {
    this.registerService.addRegUser(this.regUser).subscribe(user => {
      this.ifRegisterOk = user;
      this.sucsReg();
    });
  }

  sucsReg() {
    if (this.ifRegisterOk) {
      this.router.navigateByUrl('/registration-success-page');
    } else {
    }
  }


  uniqueLoginValidator(control: AbstractControl) {
    console.log(control);
    return this.registerService.checkLogin(control.value).map(data => {
      return data ? null : {loginNotUnique: {value: true}};
    });
  }


  uniqueEmailValidator(control: AbstractControl) {
    this.registerService.checkEmail(control.value).map(data => {
      return data ? null : {emailNotUnique: {value: true}};
    });

  }
}


export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

