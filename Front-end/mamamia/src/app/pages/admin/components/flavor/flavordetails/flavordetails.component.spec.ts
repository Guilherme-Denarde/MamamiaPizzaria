import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlavordetailsComponent } from './flavordetails.component';

describe('FlavordetailsComponent', () => {
  let component: FlavordetailsComponent;
  let fixture: ComponentFixture<FlavordetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FlavordetailsComponent]
    });
    fixture = TestBed.createComponent(FlavordetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
