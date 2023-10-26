import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ProductService } from 'src/app/middleware/services/product/product.service'; // Update the service import path accordingly
import { Product } from 'src/app/models/product/product'; // Update the model import path

@Component({
  selector: 'app-productdetails',
  templateUrl: './productdetails.component.html',
  styleUrls: ['./productdetails.component.scss']
})
export class ProductDetailsComponent {

  @Input() product: Product = new Product();
  @Output() retorno = new EventEmitter<Product>(); 

  constructor(private productService: ProductService) { } // Use ProductService instead of FlavorService

  saveProduct() {
    const productObservable = this.product.id ? 
                             this.productService.updateProduct(this.product) :
                             this.productService.createProduct(this.product);

    productObservable.subscribe({
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
