import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { OrderlistComponent } from './orderlist.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('OrderlistComponent', () => {
  let component: OrderlistComponent;
  let fixture: ComponentFixture<OrderlistComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OrderlistComponent],
      imports: [HttpClientTestingModule],
      schemas: [
        CUSTOM_ELEMENTS_SCHEMA, 
        NO_ERRORS_SCHEMA
      ]
    });
    fixture = TestBed.createComponent(OrderlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
