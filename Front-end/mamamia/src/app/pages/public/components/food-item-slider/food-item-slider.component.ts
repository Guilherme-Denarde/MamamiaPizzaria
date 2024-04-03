import { Component, ViewChild, ElementRef, OnInit } from '@angular/core';
import { ProductService } from 'src/app/middleware/services/product/product.service';
import { Product } from 'src/app/models/product/product';

@Component({
  selector: 'app-food-item-slider',
  templateUrl: './food-item-slider.component.html',
  styleUrls: ['./food-item-slider.component.scss']
})
export class FoodItemSliderComponent implements OnInit {

  lista: Product[] = [];

  @ViewChild('foodSlider', { static: false }) foodSlider!: ElementRef;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.listAll();
  }

  listAll() {
    // Retrieve the headers
    const headers = this.productService.getHeaders();
  
    // Pass the headers to the getAllProducts method
    this.productService.getAllProducts().subscribe({
      next: data => {
        console.log('Data:', data);
        this.lista = data;
      },
      error: error => {
        console.log('Error:', error);
      }
    });
  }


  move(direction: string) {
    if (direction === 'prev') {
      this.foodSlider.nativeElement.scrollLeft -= 70;
    } else {
      this.foodSlider.nativeElement.scrollLeft += 70;
    }
  }
}
