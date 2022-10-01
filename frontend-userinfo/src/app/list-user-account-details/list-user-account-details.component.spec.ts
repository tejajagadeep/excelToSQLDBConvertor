import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListUserAccountDetailsComponent } from './list-user-account-details.component';

describe('ListUserAccountDetailsComponent', () => {
  let component: ListUserAccountDetailsComponent;
  let fixture: ComponentFixture<ListUserAccountDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListUserAccountDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListUserAccountDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
