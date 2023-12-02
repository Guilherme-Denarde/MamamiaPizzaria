import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Order } from 'src/app/models/orders/orders';
import { Product } from 'src/app/models/product/product';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  order!: Order;
  products: Product[] = [];
  totalPrice: number = 0;
  itemCount: number = 0;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.fetchProducts();
  }

  fetchProducts(): void {
    this.http.get<Product[]>('http://localhost:8081/api/products/findAll').subscribe(data => {
        this.products = data;
        this.itemCount = this.products.length;
        this.totalPrice = this.products.reduce((acc, curr) => acc + curr.price, 0);
    });
  }
}