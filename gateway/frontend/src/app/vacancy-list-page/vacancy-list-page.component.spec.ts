import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {VacancyListPageComponent} from './vacancy-list-page.component';

describe('VacancyListPageComponent', () => {
  let component: VacancyListPageComponent;
  let fixture: ComponentFixture<VacancyListPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [VacancyListPageComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VacancyListPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
