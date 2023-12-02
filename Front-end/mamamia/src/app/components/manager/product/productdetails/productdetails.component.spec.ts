import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { ProductDetailsComponent } from './productdetails.component';
import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { Flavor } from 'src/app/models/flavor/flavor';
import { Product } from 'src/app/models/product/product';


describe('ProductdetailsComponent', () => {
  let component: ProductDetailsComponent;
  let fixture: ComponentFixture<ProductDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProductDetailsComponent],
      imports: [HttpClientTestingModule],
      providers: [
        { provide: HttpClient, useClass: HttpClient }, 
      ],
      schemas: [
        CUSTOM_ELEMENTS_SCHEMA, 
        NO_ERRORS_SCHEMA
      ]
    });
    
    fixture = TestBed.createComponent(ProductDetailsComponent);
    component = fixture.componentInstance;

    const mockFlavor: Flavor = {
      id: 1,
      nome: 'Margarita',
      preco_adicional: 5.50,
      descricao: 'Tomate, Queijo, Manjericão'
    };

    const mockProduct: Product = {
      id: 1,
      name: 'Pizza Margherita',
      description: 'Delicious pizza with fresh tomatoes',
      price: 10.99,
      flavor: mockFlavor,
      quantity: 2,
      imageUrl: 'path/to/image.jpg',
      stars: 5
    };

    component.product = mockProduct;

    fixture.detectChanges();
    
  });

  

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
