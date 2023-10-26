import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterUserDetailsComponent } from './register-userdetails.component';

describe('RegisterUserdetailsComponent', () => {
  let component: RegisterUserDetailsComponent;
  let fixture: ComponentFixture<RegisterUserDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterUserDetailsComponent]
    });
    fixture = TestBed.createComponent(RegisterUserDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
