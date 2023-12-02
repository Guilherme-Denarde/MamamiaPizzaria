import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { FlavorDetailsComponent } from './flavordetails.component';
import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('FlavorDetailsComponent', () => {
  let component: FlavorDetailsComponent;
  let fixture: ComponentFixture<FlavorDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FlavorDetailsComponent],
      providers: [
        { provide: HttpClient, useClass: HttpClient }, 
      ],
      imports: [HttpClientTestingModule],
      schemas: [
        CUSTOM_ELEMENTS_SCHEMA, 
        NO_ERRORS_SCHEMA
      ]
    });
    fixture = TestBed.createComponent(FlavorDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  
});
