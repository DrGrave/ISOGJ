import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MoreUserInfoPageComponent } from './more-user-info-page.component';

describe('MoreUserInfoPageComponent', () => {
  let component: MoreUserInfoPageComponent;
  let fixture: ComponentFixture<MoreUserInfoPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MoreUserInfoPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MoreUserInfoPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
