import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PedidoDialogComponent } from './pedido-dialog.component';
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


describe('PedidoDialogComponent', () => {
  let component: PedidoDialogComponent;
  let fixture: ComponentFixture<PedidoDialogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PedidoDialogComponent],
      imports: [
        MatSnackBarModule, HttpClientTestingModule, FormsModule
      ],
      providers: [
        { provide: MatDialogRef, useValue: mockDialogRef },
        { provide: MatDialog, useValue: mockMatDialog }
      ]
    });
    fixture = TestBed.createComponent(PedidoDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
