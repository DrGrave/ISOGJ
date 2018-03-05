import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorizedUserListPageComponent } from './authorized-user-list-page.component';

describe('AuthorizedUserListPageComponent', () => {
  let component: AuthorizedUserListPageComponent;
  let fixture: ComponentFixture<AuthorizedUserListPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthorizedUserListPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorizedUserListPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
