import { Injectable, inject } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from 'src/app/models/product/product';
import { Order, Payment, OrderSize, OrderState } from '../../../models/orders/orders'; // <-- Importe a model Order
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {
  
  API = 'http://backend:8080/api/produto';
  http = inject(HttpClient);

  pedidoURI = '';
  formularioURI = '';

  orders: Order[] = [];  
  pedidos: Product[] = [];
  

  constructor(private _snackBar: MatSnackBar) {}

  horizontalPosition: MatSnackBarHorizontalPosition = 'right';
  verticalPosition: MatSnackBarVerticalPosition = 'top';


  openSnackBar(msg: string) {
    this._snackBar.open(msg, 'X', {
      duration: 700,
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
    });
  }

  // getOrders(): Observable<any[]> {
  //   return this.http.get<any[]>(this.ordersUrl);
  // }

  getPedidoValues(item: string, price: number) {
    const newOrder: Order = {
      id: this.orders.length,
      payment: Payment.MONEY, 
      orderSize: OrderSize.M, 
      orderState: OrderState.OPEN,
      mustDeliver: false, 
      orderTime: new Date(), 
      priceTotal: price
    };
    this.orders.push(newOrder);
  }



addPedido(product: Product) {
    this.pedidos.push(product);
    this.openSnackBar('Pedido adicionado!');
}

getPedidos(): Product[] {
  return this.pedidos;
}

  listAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.API);
  }

  save(produto: Product): Observable<Product> {
    return this.http.post<Product>(this.API, produto);
  }

  exemploErro(): Observable<Product[]> {
    return this.http.get<Product[]>(this.API + '/erro');
  }
}
