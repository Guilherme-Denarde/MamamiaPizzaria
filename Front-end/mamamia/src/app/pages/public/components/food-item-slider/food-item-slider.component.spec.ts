import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodItemSliderComponent } from './food-item-slider.component';

describe('FoodItemSliderComponent', () => {
  let component: FoodItemSliderComponent;
  let fixture: ComponentFixture<FoodItemSliderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FoodItemSliderComponent]
    });
    fixture = TestBed.createComponent(FoodItemSliderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
