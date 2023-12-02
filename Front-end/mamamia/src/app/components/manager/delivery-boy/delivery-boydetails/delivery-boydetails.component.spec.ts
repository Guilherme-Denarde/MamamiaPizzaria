import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeliveryBoydetailsComponent } from './delivery-boydetails.component';

describe('DeliveryBoydetailsComponent', () => {
  let component: DeliveryBoydetailsComponent;
  let fixture: ComponentFixture<DeliveryBoydetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DeliveryBoydetailsComponent]
    });
    fixture = TestBed.createComponent(DeliveryBoydetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
