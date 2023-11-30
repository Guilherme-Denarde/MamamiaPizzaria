import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdersListComponent } from './orders-list.component';
import { MAT_DIALOG_DATA, MatDialogModule, MatDialogRef } from '@angular/material/dialog';

describe('OrdersListComponent', () => {
  let component: OrdersListComponent;
  let fixture: ComponentFixture<OrdersListComponent>;

  
  const mockDialogRef = {
    close: jasmine.createSpy('close')
  };
  
  const mockOrdersData = {
    orders: [
      { price: 10 },
      { price: 20 }
    ]
  };

  
  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OrdersListComponent],
      imports: [
        MatDialogModule
      ],
      providers: [
        { provide: MAT_DIALOG_DATA,  useValue: mockOrdersData},
        { provide: MatDialogRef, useValue: mockDialogRef } 
      ]
    });
    fixture = TestBed.createComponent(OrdersListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
