import {Component} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import * as token from './login-page/login-page.component'

@Component({
  selector: 'app-root',
  template: `
    <app-header></app-header>
    <router-outlet></router-outlet>
  `,
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  constructor(private translate: TranslateService) {
    translate.addLangs(['en', 'ru']);
    const currLang = localStorage.getItem('isogj-locale');
    this.translate.setDefaultLang('en');
    if (currLang == null) {

      const browserLang = translate.getBrowserLang();

      const lang = browserLang.match('^(en|ru)$') ? browserLang : translate.getDefaultLang();
      translate.use(lang);
      localStorage.setItem('isogj-locale', lang);
    } else {
      translate.use(currLang);
    }
  }

}
