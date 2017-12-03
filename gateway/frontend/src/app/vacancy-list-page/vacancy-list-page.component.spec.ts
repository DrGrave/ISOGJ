import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyListPageComponent } from './vacancy-list-page.component';

describe('VacancyListPageComponent', () => {
  let component: CompanyListPageComponent;
  let fixture: ComponentFixture<CompanyListPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompanyListPageComponent ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompanyListPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
