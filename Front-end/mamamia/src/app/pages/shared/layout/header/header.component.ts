import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Order, OrderState, Payment } from 'src/app/models/orders/orders';
import { Product } from 'src/app/models/product/product';
import { MatDialog } from '@angular/material/dialog';
import { CookieService } from 'ngx-cookie-service';

import { OrdersService } from 'src/app/middleware/services/orders/orders.service';
import { OrdersListComponent } from '../../../public/components/orders-list/orders-list.component';
import { PaymentFormComponent } from '../../components/payment-form/payment-form.component';
import { RegisterUserService } from 'src/app/middleware/services/register-user/register-user.service';
import { Router } from '@angular/router';
import { Client } from 'src/app/models/client/client';
import { ClientService } from '../../../../middleware/services/client/client.service';
import eventService from 'src/app/pages/public/components/orders-list/event.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  order!: Order;
  products: Product[] = [];
  totalPrice = 0;
  itemCount = 0;
  role: string | null = null;
  client! : Client;

  selectedProducts!: Product[];

  

    constructor(private clientService : ClientService, private router: Router,private cookieService: CookieService,private http: HttpClient,private dialog: MatDialog, private ordersService: OrdersService, private userService: RegisterUserService) {

      eventService.listen("shop", (data) => {

        this.selectedProducts = data;



        this.shop();
      }) ;
    }

  ngOnInit(): void {
    this.role = this.userService.getRole();
    console.log(this.role);
    this.fetchProducts();

    this.clientService.me().subscribe( (data:any) => {

      this.client = data.client;

    } );
  }


  shop () :void {

    

     let valor  = 0;


    for (let i = 0; i < this.products.length; i++){

      valor += this.products[i].price;
    }

   


    const compra = {
      
      payment: Payment.MONEY,
      orderState: OrderState.OPEN,
      mustDeliver: false,
      orderTime: new Date(),
      priceTotal: valor,
      client: this.client,
      items: this.selectedProducts,
    }

    console.log(compra);

    this.ordersService.save(compra).subscribe( (data:any) => {

      console.log(data);

    } );

    
  }
  
  fetchProducts(): void {
    const token = this.cookieService.get('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    
    this.http.get<Product[]>('http://localhost:8081/api/products/findAll', { headers: headers }).subscribe(data => {
      this.products = data;
      this.itemCount = this.products.length;
      this.totalPrice = this.products.reduce((acc, curr) => acc + curr.price, 0);
    });
  }

  openOrdersList() {
    const orders = this.ordersService.getPedidos();
    const dialogRef = this.dialog.open(OrdersListComponent, {
        width: '400px',
        data: { orders: orders }
    });
}

openPaymentMethodModal() {
  const dialogRef = this.dialog.open(PaymentFormComponent, {
    width: '500px',
    // ... any other configurations for your dialog
  });

}

logout(): void {
  this.cookieService.deleteAll();
  this.router.navigate(['/login']);
}



}