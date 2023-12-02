import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Product } from 'src/app/models/product/product'; // Update the model import path
import { ProductService } from 'src/app/services/product/product.service';

@Component({
  selector: 'app-productdetails',
  templateUrl: './productdetails.component.html',
  styleUrls: ['./productdetails.component.scss']
})
export class ProductDetailsComponent {

  @Input() product: Product = new Product();
  @Output() retorno = new EventEmitter<Product>(); 

  constructor(private productService: ProductService) { }

  saveProduct() {
                             
                             

     this.productService.createProduct(this.product).subscribe({
        next: product => { 
            this.retorno.emit(product);
        },
        error: erro => { 
            alert('Example of error/exception handling! Check the error in the console!');
            console.error(erro);
        }
    });
  }
}
