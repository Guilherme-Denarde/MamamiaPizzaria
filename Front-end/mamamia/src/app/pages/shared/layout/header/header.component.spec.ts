import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HeaderComponent } from './header.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';


const mockDialogRef = {
  close: jasmine.createSpy('close')
};

const mockMatDialog = {
  open: jasmine.createSpy('open')
};


describe('HeaderComponent', () => {
  let component: HeaderComponent;
  let fixture: ComponentFixture<HeaderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HeaderComponent],
      schemas: [
        CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA //PARA QUE O KARMA NÃO CONFUNDA ELEMENTOS ANGULAR NO TEMPLATE COMO ERROS
      ],
      imports: [
        MatSnackBarModule, HttpClientTestingModule, FormsModule
      ],
      providers: [
        { provide: MatDialogRef, useValue: mockDialogRef },
        { provide: MatDialog, useValue: mockMatDialog }
      ]
    });
    fixture = TestBed.createComponent(HeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
