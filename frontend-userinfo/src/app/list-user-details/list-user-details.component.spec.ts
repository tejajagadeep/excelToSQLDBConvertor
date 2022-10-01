import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListUserDetailsComponent } from './list-user-details.component';

describe('ListUserDetailsComponent', () => {
  let component: ListUserDetailsComponent;
  let fixture: ComponentFixture<ListUserDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListUserDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListUserDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
