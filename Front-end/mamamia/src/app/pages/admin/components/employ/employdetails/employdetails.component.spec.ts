import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { EmploydetailsComponent } from './employdetails.component';
import { HttpClient } from '@angular/common/http';

describe('EmploydetailsComponent', () => {
  let component: EmploydetailsComponent;
  let fixture: ComponentFixture<EmploydetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmploydetailsComponent],
      providers: [
        { provide: HttpClient, useClass: HttpClient }, 
      ],
      schemas: [
        CUSTOM_ELEMENTS_SCHEMA, 
        NO_ERRORS_SCHEMA
      ]
    });
    fixture = TestBed.createComponent(EmploydetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
