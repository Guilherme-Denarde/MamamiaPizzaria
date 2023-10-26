import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlavorDetailsComponent } from './flavordetails.component';

describe('FlavorDetailsComponent', () => {
  let component: FlavorDetailsComponent;
  let fixture: ComponentFixture<FlavorDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FlavorDetailsComponent]
    });
    fixture = TestBed.createComponent(FlavorDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
