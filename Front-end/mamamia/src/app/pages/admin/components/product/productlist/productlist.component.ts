import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit, Inject } from '@angular/core'; 
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ProductService } from 'src/app/middleware/services/product/product.service'; 
import { Product } from 'src/app/models/product/product';
import { CookieService } from 'ngx-cookie-service';
import { HeaderComponent } from '../../../../shared/layout/header/header.component';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html', 
  styleUrls: ['./productlist.component.scss'] 
})
export class ProductListComponent implements OnInit {  
  
  products: Product[] = [];
  isValidName = true;
  selectedProductForEdit: Product = new Product();

  constructor(private cookieService: CookieService,private modalService: NgbModal, private productService: ProductService) { }

  ngOnInit(): void {
    this.listAllProducts();
  }

  private getHeaders(): HttpHeaders {
    const token = this.cookieService.get('token');
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
  }

  listAllProducts(): void {
    this.productService.getAllProducts().subscribe(
      data => {
        this.products = data;
        this.products.sort((a, b) => b.id - a.id);
        console.log(this.products);
      },
      error => {
        console.error('Error:', error);
        // alert('An error occurred. Please check the console for more details.');
      }
    );
  }

  addProduct(modal: any): void {
    this.selectedProductForEdit = new Product();
    this.modalService.open(modal, { size: 'sm' });
  }

  editProduct(modal: any, product: Product, index: number): void {
    this.selectedProductForEdit = Object.assign({}, product);
    this.modalService.open(modal, { size: 'sm' });
  }

  saveOrUpdateProduct(product: Product): void {
    if (!product.name) {
      alert('Please insert valid data.');
      return;
    }

    const productObservable = product.id ? 
                             this.productService.updateProduct(product) : 
                             this.productService.createProduct(product);

    productObservable.subscribe(
      responseProduct => {
        const index = this.products.findIndex(p => p.id === responseProduct.id);
        if (index !== -1) {
          this.products[index] = responseProduct;
          alert('Product updated successfully!');
        } else {
          this.products.unshift(responseProduct);
          alert('Product added successfully!');
        }
      },
      error => {
        const action = product.id ? "update" : "add";
        alert(`An error occurred while trying to ${action} the product.`);
        console.error(error);
      }
    );

    this.modalService.dismissAll();
  }

  deleteProduct(product: Product): void {
    if (!product.id) {
      console.error('Product ID is undefined or null. Cannot delete product.');
      alert('Error: Cannot delete product without a valid ID.');
      return;
    }

    if (confirm('Are you sure you want to delete this product?')) {
      this.productService.deleteProduct(product.id).subscribe(
        () => {
          const index = this.products.findIndex(p => p.id === product.id);
          if (index !== -1) {
            this.products.splice(index, 1);
          }
          alert('Product deleted successfully!');
        },
        error => {
          alert('An error occurred while trying to delete the product.');
          console.error(error);
        }
      );
    }
  }

  validateName(name: string): void {
    this.isValidName = !!name.trim(); 
  }


  
}
