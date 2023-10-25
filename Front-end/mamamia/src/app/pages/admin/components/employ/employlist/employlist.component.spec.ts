import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmploylistComponent } from './employlist.component';

describe('EmploylistComponent', () => {
  let component: EmploylistComponent;
  let fixture: ComponentFixture<EmploylistComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmploylistComponent]
    });
    fixture = TestBed.createComponent(EmploylistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
