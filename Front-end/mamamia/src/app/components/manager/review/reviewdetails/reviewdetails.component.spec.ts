import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { ReviewdetailsComponent } from './reviewdetails.component';
import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('ReviewdetailsComponent', () => {
  let component: ReviewdetailsComponent;
  let fixture: ComponentFixture<ReviewdetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReviewdetailsComponent],
      imports: [HttpClientTestingModule],
      providers: [
        { provide: HttpClient, useClass: HttpClient },

      ],
      schemas: [
        CUSTOM_ELEMENTS_SCHEMA, 
        NO_ERRORS_SCHEMA
      ]
    });
    fixture = TestBed.createComponent(ReviewdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
