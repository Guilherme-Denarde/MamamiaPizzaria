import { TestBed } from '@angular/core/testing';

import { AddressService } from './address.service';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('AddressService', () => {
  let service: AddressService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        MatSnackBarModule,HttpClientTestingModule
      ],
    });
    service = TestBed.inject(AddressService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
