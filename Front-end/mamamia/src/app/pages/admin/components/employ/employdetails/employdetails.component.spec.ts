import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmploydetailsComponent } from './employdetails.component';

describe('EmploydetailsComponent', () => {
  let component: EmploydetailsComponent;
  let fixture: ComponentFixture<EmploydetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmploydetailsComponent]
    });
    fixture = TestBed.createComponent(EmploydetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
