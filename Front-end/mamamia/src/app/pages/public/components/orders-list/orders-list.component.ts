
import { Component, Inject, Injectable, inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';
import { Order } from 'src/app/models/orders/orders';
import { Product } from 'src/app/models/product/product';
import { MatDialogRef } from '@angular/material/dialog';
import { PedidoFormComponent } from 'src/app/pages/shared/layout/pedido-form/pedido-form.component';
import { PaymentFormComponent } from 'src/app/pages/shared/components/payment-form/payment-form.component';
import eventService from './event.service';


@Component({
  selector: 'app-orders-list',
  templateUrl: './orders-list.component.html',
  styleUrls: ['./orders-list.component.scss']
})
export class OrdersListComponent {

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: { orders: Product[] },
    
    private dialogRef: MatDialogRef<OrdersListComponent>,private dialog: MatDialog
  ) { }

products: Product[] = [];


openPaymentMethodModal() {
  const dialogRef = this.dialog.open(PaymentFormComponent, {
    width: '500px',
    
  });
}



getTotalPrice(): number {
  if (this.data && Array.isArray(this.data.orders)) {
    return this.data.orders.reduce((acc: number, product: Product) => acc + product.price, 0);
  }
  return 0;
}

openOrderForm() {
  const dialogRef = this.dialog.open(PedidoFormComponent, {
    width: '500px',
  });
}

deleteProduct(product: Product): void {
  const index = this.data.orders.indexOf(product);
  if (index > -1) {
    this.data.orders.splice(index, 1);
  }
}

closeModal(): void {
  this.dialogRef.close();
}

shope () {
eventService.emit("shop", this.products);
  
}


}
