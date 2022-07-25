import { TestBed } from '@angular/core/testing';

import { ShoeApiService } from './shoe-api.service';

describe('ShoeApiService', () => {
  let service: ShoeApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShoeApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
