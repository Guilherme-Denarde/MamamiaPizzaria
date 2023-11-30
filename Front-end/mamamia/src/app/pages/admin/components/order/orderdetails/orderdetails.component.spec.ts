import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { OrderdetailsComponent } from './orderdetails.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';


describe('OrderdetailsComponent', () => {
  let component: OrderdetailsComponent;
  let fixture: ComponentFixture<OrderdetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OrderdetailsComponent],
      imports: [HttpClientTestingModule],
      schemas: [
        CUSTOM_ELEMENTS_SCHEMA, 
        NO_ERRORS_SCHEMA
      ]
    });
    fixture = TestBed.createComponent(OrderdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
