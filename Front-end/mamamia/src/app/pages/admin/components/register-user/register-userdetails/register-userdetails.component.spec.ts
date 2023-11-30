import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { RegisterUserDetailsComponent } from './register-userdetails.component';
import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('RegisterUserdetailsComponent', () => {
  let component: RegisterUserDetailsComponent;
  let fixture: ComponentFixture<RegisterUserDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterUserDetailsComponent],
      imports: [HttpClientTestingModule],
      providers: [
        { provide: HttpClient, useClass: HttpClient }, 
      ],
      schemas: [
        CUSTOM_ELEMENTS_SCHEMA, 
        NO_ERRORS_SCHEMA
      ]
    });
    fixture = TestBed.createComponent(RegisterUserDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
