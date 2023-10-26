import { Component,Input,OnInit  } from '@angular/core';
import { Order } from 'src/app/models/orders/orders';
import { OrdersService } from 'src/app/middleware/services/orders/orders.service';
import { Product } from 'src/app/models/product/product';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-store-list',
  templateUrl: './store-list.component.html',
  styleUrls: ['./store-list.component.scss']
})
export class StoreListComponent implements OnInit {

  pizzasArray: Product[] = [];
  @Input() lista: any[] = [];

  constructor(private ordersService: OrdersService) {}

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


  ngOnInit(): void {
  }

}