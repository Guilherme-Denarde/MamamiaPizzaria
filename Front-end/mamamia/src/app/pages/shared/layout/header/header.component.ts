import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Order } from 'src/app/models/orders/orders';
import { Product } from 'src/app/models/product/product';
import { MatDialog } from '@angular/material/dialog';
import { CookieService } from 'ngx-cookie-service';

import { OrdersService } from 'src/app/middleware/services/orders/orders.service';
import { OrdersListComponent } from '../../../public/components/orders-list/orders-list.component';
import { PaymentFormComponent } from '../../components/payment-form/payment-form.component';
import { RegisterUserService } from 'src/app/middleware/services/register-user/register-user.service';
import { Router } from '@angular/router';

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

    constructor(private router: Router,private cookieService: CookieService,private http: HttpClient,private dialog: MatDialog, private ordersService: OrdersService, private userService: RegisterUserService) {}

  ngOnInit(): void {
    this.role = this.userService.getRole();
    console.log(this.role);
    this.fetchProducts();
  }
  
  fetchProducts(): void {
    const token = this.cookieService.get('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    
    this.http.get<Product[]>('http://localhost:8080/api/products/findAll', { headers: headers }).subscribe(data => {
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