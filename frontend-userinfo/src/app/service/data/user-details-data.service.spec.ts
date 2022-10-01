import { TestBed } from '@angular/core/testing';

import { UserDetailsDataService } from './user-details-data.service';

describe('UserDetailsDataService', () => {
  let service: UserDetailsDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserDetailsDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
