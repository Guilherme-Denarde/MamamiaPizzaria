import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StoreListComponent } from './store-list.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';

describe('StoreListComponent', () => {
  let component: StoreListComponent;
  let fixture: ComponentFixture<StoreListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StoreListComponent],
      imports: [
        MatSnackBarModule, HttpClientTestingModule, FormsModule
      ],
    });
    fixture = TestBed.createComponent(StoreListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
