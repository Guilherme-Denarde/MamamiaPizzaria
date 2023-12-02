import { Injectable, inject } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from 'src/app/models/product/product';

import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';
import { ClientService } from '../client/client.service';
import { Client } from 'src/app/models/client/client';
import { CookieService } from 'ngx-cookie-service';
import { Order, OrderSize, OrderState, Payment } from 'src/app/models/orders/orders';

@Injectable({
  providedIn: 'root',
})
export class OrdersService {
  constructor(
    private _snackBar: MatSnackBar,
    private client: ClientService,
    private cookieService: CookieService
  ) {}

  API = 'http://localhost:8081/api/orders';
  http = inject(HttpClient);

  token = this.cookieService.get('token');
  headers = new HttpHeaders({ Authorization: `Bearer ${this.token}` });

  pedidoURI = '';
  formularioURI = '';

  orders: Order[] = [];
  pedidos: Product[] = [];

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
      priceTotal: price,
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

  save(produto: any) {
    return this.http.post(`${this.API}`, produto, { headers: this.headers });
  }

  exemploErro(): Observable<Product[]> {
    return this.http.get<Product[]>(this.API + '/erro');
  }
}
