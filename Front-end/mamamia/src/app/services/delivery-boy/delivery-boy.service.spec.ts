import { TestBed } from '@angular/core/testing';

import { DeliveryBoyService } from './delivery-boy.service';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('DeliveryBoyService', () => {
  let service: DeliveryBoyService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        MatSnackBarModule,HttpClientTestingModule
      ],
    });
    service = TestBed.inject(DeliveryBoyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
