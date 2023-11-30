import { TestBed } from '@angular/core/testing';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { OrdersService } from './orders.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { Product } from 'src/app/models/product/product';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpErrorResponse } from '@angular/common/http';

describe('OrdersService', () => {
  let service: OrdersService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        MatSnackBarModule,HttpClientTestingModule,BrowserAnimationsModule
      ],
      
    });
    service = TestBed.inject(OrdersService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify(); 
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should add a product to pedidos', () => {
    const product: Product = {
      id: 1,
      name: 'Product Test',
      description: 'Test Description',
      price: 29.99,
      flavor: { id: 2,  nome: 'Flavor 2', preco_adicional: 7.99, descricao: 'Ingredient 3, Ingredient 4' },
      quantity: 5,
      imageUrl: 'test-image-url.jpg',
      stars: 4.0,
    };

    service.addPedido(product);
    const pedidos = service.getPedidos();
    expect(pedidos.length).toBe(1);
    expect(pedidos[0]).toEqual(product);
  });

  it('should open a snackbar', () => {
    const spy = spyOn(service['_snackBar'], 'open');
    service.openSnackBar('Test Message');
    expect(spy).toHaveBeenCalledWith('Test Message', 'X', {
      duration: 700,
      horizontalPosition: 'right',
      verticalPosition: 'top',
    });
  });

  it('should save a product', () => {
    const product: Product = {
      id: 1,
      name: 'Product Test',
      description: 'Test Description',
      price: 29.99,
      flavor: { id: 2, nome: 'Flavor 2', preco_adicional: 7.99, descricao: 'Ingredient 3, Ingredient 4' },
      quantity: 5,
      imageUrl: 'test-image-url.jpg',
      stars: 4.0,
    };

    service.save(product).subscribe((savedProduct) => {
      expect(savedProduct).toEqual(product);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('POST');
    req.flush(product);
  });

  it('should list all products', () => {
    // Crie uma lista de produtos falsos para o teste
    const mockProducts: Product[] = [
        {
            id: 1,
            name: 'Product 1',
            description: 'Description 1',
            price: 19.99,
            flavor: { id: 1, nome: 'Flavor 1', preco_adicional: 5.99, descricao: 'Ingredient 1, Ingredient 2' },
            quantity: 10,
            imageUrl: 'image1.jpg',
            stars: 4.5,
        },
        {
            id: 2,
            name: 'Product 2',
            description: 'Description 2',
            price: 24.99,
            flavor: { id: 2, nome: 'Flavor 2', preco_adicional: 6.99, descricao: 'Ingredient 3, Ingredient 4' },
            quantity: 8,
            imageUrl: 'image2.jpg',
            stars: 4.0,
        },
        
    ];

    service.listAll().subscribe((products) => {
        expect(products).toEqual(mockProducts);
    });
    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('GET');
    req.flush(mockProducts);
});

});
