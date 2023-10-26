import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

// Importações do Angular Material
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';

import { PedidoFormComponent } from '../pedido-form/pedido-form.component';
import { PedidoComponent } from './pedido.component';

@NgModule({
  declarations: [
    PedidoFormComponent,
    PedidoComponent
  ],
  imports: [
    CommonModule,
    FormsModule, 
    MatIconModule,
    MatButtonModule,
    MatDialogModule,
    MatInputModule,
    MatFormFieldModule
  ],
  exports: [
    PedidoFormComponent,
    PedidoComponent
  ]
})
export class PedidoModule { }
