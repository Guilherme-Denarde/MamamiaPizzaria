import { TestBed } from '@angular/core/testing';
import { CookieService } from 'ngx-cookie-service';
import { ProductService } from './product.service';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { Flavor } from 'src/app/models/flavor/flavor';
import { Product } from 'src/app/models/product/product';

describe('ProductService', () => {
  let service: ProductService;
  let httpMock: HttpTestingController;
  let cookieService: CookieService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        MatSnackBarModule,HttpClientTestingModule
      ],
    });
    service = TestBed.inject(ProductService);
    httpMock = TestBed.inject(HttpTestingController);
    cookieService = TestBed.inject(CookieService); 
  });

  afterEach(() => {
    httpMock.verify(); 
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should create a flavor', () => {
    const flavor: Flavor = {
      id: 1, 
      nome: 'Sabor Teste', 
      preco_adicional: 10.99,
      descricao: 'Ingrediente 1, Ingrediente 2',
    };

    service.createFlavor(flavor).subscribe((createdFlavor) => {
      expect(createdFlavor).toEqual(flavor); 
    });

    const req = httpMock.expectOne(`${service.API}/flavors`);
    expect(req.request.method).toBe('POST');
    req.flush(flavor); 
  });

  it('should get all flavors', () => {
    const dummyFlavors: Flavor[] = [
      { id: 1, nome: 'Flavor 1', preco_adicional: 10.99, descricao: 'Ingrediente 1, Ingrediente 2' },
      { id: 2, nome: 'Flavor 2', preco_adicional: 9.99, descricao: 'Ingrediente 3, Ingrediente 4' },
    ];

    service.getAllFlavors().subscribe((flavors) => {
      expect(flavors).toEqual(dummyFlavors); 
    });

    const req = httpMock.expectOne(`${service.API}/flavors/findAll`);
    expect(req.request.method).toBe('GET');
    req.flush(dummyFlavors); 
  });

  it('should delete a flavor', () => {
    const flavorIdToDelete = 1;
  
    service.deleteFlavor(flavorIdToDelete).subscribe((response) => {
      expect(response).toBe('Flavor deleted successfully');
    });
  
    const req = httpMock.expectOne(`${service.API}/flavors/delete?id=${flavorIdToDelete}`);
    expect(req.request.method).toBe('DELETE');
    req.flush('Flavor deleted successfully');
  });

  it('should create a product', () => {
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
  
    service.createProduct(product).subscribe((createdProduct) => {
      expect(createdProduct).toEqual(product);
    });
  
    const req = httpMock.expectOne(`${service.API}`);
    expect(req.request.method).toBe('POST');
    req.flush(product);
  });

  it('should update a product', () => {
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

    service.updateProduct(product).subscribe((updatedProduct) => {
      expect(updatedProduct).toEqual(product);
    });

    const req = httpMock.expectOne(`${service.API}/update?id=${product.id}`);
    expect(req.request.method).toBe('PUT');
    req.flush(product);
  });

  



});
  