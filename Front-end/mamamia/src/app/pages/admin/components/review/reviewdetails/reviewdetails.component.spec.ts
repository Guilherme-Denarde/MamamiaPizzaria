import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewdetailsComponent } from './reviewdetails.component';

describe('ReviewdetailsComponent', () => {
  let component: ReviewdetailsComponent;
  let fixture: ComponentFixture<ReviewdetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReviewdetailsComponent]
    });
    fixture = TestBed.createComponent(ReviewdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
