import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { FoodItemSliderComponent } from './food-item-slider.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpClient } from '@angular/common/http';

describe('FoodItemSliderComponent', () => {
  let component: FoodItemSliderComponent;
  let fixture: ComponentFixture<FoodItemSliderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FoodItemSliderComponent],
      imports: [HttpClientTestingModule],
      providers: [
        { provide: HttpClient, useClass: HttpClient }, 
      ],
      schemas: [
        CUSTOM_ELEMENTS_SCHEMA, 
        NO_ERRORS_SCHEMA
      ]
    });
    fixture = TestBed.createComponent(FoodItemSliderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
