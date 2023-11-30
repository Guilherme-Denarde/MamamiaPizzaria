import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PedidoFormComponent } from './pedido-form.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';

// Mock para MatDialogRef
const mockDialogRef = {
  close: jasmine.createSpy('close')
};

const mockMatDialog = {
  open: jasmine.createSpy('open')
};

describe('PedidoFormComponent', () => {
  let component: PedidoFormComponent;
  let fixture: ComponentFixture<PedidoFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PedidoFormComponent],
      imports: [
        MatSnackBarModule, HttpClientTestingModule, FormsModule
      ],
      providers: [
        { provide: MatDialogRef, useValue: mockDialogRef },
        { provide: MatDialog, useValue: mockMatDialog }
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(PedidoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
