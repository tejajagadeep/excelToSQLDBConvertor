import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadUserAccountInfoComponent } from './upload-user-account-info.component';

describe('UploadUserAccountInfoComponent', () => {
  let component: UploadUserAccountInfoComponent;
  let fixture: ComponentFixture<UploadUserAccountInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UploadUserAccountInfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadUserAccountInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
