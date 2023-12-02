import { Component,Input,OnInit  } from '@angular/core';
import { Order } from 'src/app/models/orders/orders';
import { Product } from 'src/app/models/product/product';
import { MatDialogRef } from '@angular/material/dialog';
import { ProductService } from 'src/app/services/product/product.service';
import { OrdersService } from 'src/app/services/orders/orders.service';

@Component({
  selector: 'app-store-list',
  templateUrl: './store-list.component.html',
  styleUrls: ['./store-list.component.scss']
})
export class StoreListComponent implements OnInit {

  pizzasArray: Product[] = [];
  @Input() lista: any[] = [];

  constructor(private productService: ProductService, private ordersService: OrdersService) {}
  products: Product[] = [];
  ngOnInit(): void {
    this.productService.getAllProducts().subscribe(
      (data: Product[]) => {
        this.products = data;
        console.log('Fetched products:', this.products);
      },
      (error: any) => {
        console.error('Error fetching products:', error);
      }
    );
  }

  addPizzaPedido(id: number) {
    this.pizzasArray.forEach((value)=> {
      if(value.id === id){
        this.ordersService.getPedidoValues(value.name, value.price);  
        this.ordersService.openSnackBar('Pizza adicionada!'); 
      }
    });
  }

  addPedido(product: any) {
    this.ordersService.addPedido(product);
}


 

}