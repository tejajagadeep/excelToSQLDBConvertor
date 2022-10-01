import { TestBed } from '@angular/core/testing';

import { UserAccountDetailsDataService } from './user-account-details-data.service';

describe('UserAccountDetailsDataService', () => {
  let service: UserAccountDetailsDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserAccountDetailsDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
