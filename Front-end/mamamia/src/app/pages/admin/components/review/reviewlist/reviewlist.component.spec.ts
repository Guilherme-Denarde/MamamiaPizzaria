import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { ReviewlistComponent } from './reviewlist.component';
import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('ReviewlistComponent', () => {
  let component: ReviewlistComponent;
  let fixture: ComponentFixture<ReviewlistComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReviewlistComponent],
      imports: [HttpClientTestingModule],
      providers: [
        { provide: HttpClient, useClass: HttpClient }, 
      ],
      schemas: [
        CUSTOM_ELEMENTS_SCHEMA, 
        NO_ERRORS_SCHEMA
      ],
    });
    
    fixture = TestBed.createComponent(ReviewlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
