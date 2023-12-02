import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeliveryBoylistComponent } from './delivery-boylist.component';

describe('DeliveryBoylistComponent', () => {
  let component: DeliveryBoylistComponent;
  let fixture: ComponentFixture<DeliveryBoylistComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DeliveryBoylistComponent]
    });
    fixture = TestBed.createComponent(DeliveryBoylistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
