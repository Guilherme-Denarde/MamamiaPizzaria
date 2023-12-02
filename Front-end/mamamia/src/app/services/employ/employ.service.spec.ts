import { TestBed } from '@angular/core/testing';

import { EmployService } from './employ.service';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('EmployService', () => {
  let service: EmployService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        MatSnackBarModule,HttpClientTestingModule
      ],
    });
    service = TestBed.inject(EmployService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
