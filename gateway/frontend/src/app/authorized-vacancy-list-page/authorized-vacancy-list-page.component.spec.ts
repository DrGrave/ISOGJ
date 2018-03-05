import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorizedVacancyListPageComponent } from './authorized-vacancy-list-page.component';

describe('AuthorizedVacancyListPageComponent', () => {
  let component: AuthorizedVacancyListPageComponent;
  let fixture: ComponentFixture<AuthorizedVacancyListPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthorizedVacancyListPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorizedVacancyListPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
