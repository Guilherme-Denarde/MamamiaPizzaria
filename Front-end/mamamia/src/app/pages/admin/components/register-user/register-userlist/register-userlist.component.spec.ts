import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterUserlistComponent } from './register-userlist.component';

describe('RegisterUserlistComponent', () => {
  let component: RegisterUserlistComponent;
  let fixture: ComponentFixture<RegisterUserlistComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterUserlistComponent]
    });
    fixture = TestBed.createComponent(RegisterUserlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
