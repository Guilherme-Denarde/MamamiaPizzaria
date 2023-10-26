import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlavorListComponent } from './flavorlist.component';

describe('FlavorListComponent', () => {
  let component: FlavorListComponent;
  let fixture: ComponentFixture<FlavorListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FlavorListComponent]
    });
    fixture = TestBed.createComponent(FlavorListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
