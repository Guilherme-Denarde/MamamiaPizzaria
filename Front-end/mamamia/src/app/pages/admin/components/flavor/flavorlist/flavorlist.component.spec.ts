import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlavorListComponent } from './flavorlist.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('FlavorListComponent', () => {
  let component: FlavorListComponent;
  let fixture: ComponentFixture<FlavorListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FlavorListComponent],
      imports: [
        MatSnackBarModule,HttpClientTestingModule
      ],
    });
    fixture = TestBed.createComponent(FlavorListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
