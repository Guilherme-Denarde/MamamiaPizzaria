import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlavorlistComponent } from './flavorlist.component';

describe('FlavorlistComponent', () => {
  let component: FlavorlistComponent;
  let fixture: ComponentFixture<FlavorlistComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FlavorlistComponent]
    });
    fixture = TestBed.createComponent(FlavorlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
