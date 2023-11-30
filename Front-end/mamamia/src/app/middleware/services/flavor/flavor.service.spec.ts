import { TestBed } from '@angular/core/testing';

import { FlavorService } from './flavor.service';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { Flavor } from 'src/app/models/flavor/flavor';
import { HttpErrorResponse } from '@angular/common/http';

describe('FlavorService', () => {
  let service: FlavorService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        MatSnackBarModule,HttpClientTestingModule
      ],
    });
    service = TestBed.inject(FlavorService);
    httpMock = TestBed.inject(HttpTestingController);
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
      flavorName: 'Flavor 1',
      flavorPrice: 5.99,
      flavorIngredients: 'Ingredient 1, Ingredient 2',
    };

    service.create(flavor).subscribe((createdFlavor) => {
      expect(createdFlavor).toEqual(flavor);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('POST');
    req.flush(flavor);
  });

  it('should get all flavors', () => {
    const mockFlavors: Flavor[] = [
      {
        id: 1,
        flavorName: 'Flavor 1',
        flavorPrice: 5.99,
        flavorIngredients: 'Ingredient 1, Ingredient 2',
      },
      {
        id: 2,
        flavorName: 'Flavor 2',
        flavorPrice: 6.99,
        flavorIngredients: 'Ingredient 3, Ingredient 4',
      },
    ];

    service.getAll().subscribe((flavors) => {
      expect(flavors).toEqual(mockFlavors);
    });

    const req = httpMock.expectOne(`${service.API}/findAll`);
    expect(req.request.method).toBe('GET');
    req.flush(mockFlavors);
  });

  it('should update a flavor', () => {
    const flavor: Flavor = {
      id: 1,
      flavorName: 'Updated Flavor',
      flavorPrice: 7.99,
      flavorIngredients: 'New Ingredient 1, New Ingredient 2',
    };

    service.update(flavor).subscribe((updatedFlavor) => {
      expect(updatedFlavor).toEqual(flavor);
    });

    const req = httpMock.expectOne(`${service.API}/update?id=${flavor.id}`);
    expect(req.request.method).toBe('PUT');
    req.flush(flavor);
  });

  it('should delete a flavor', () => {
    const flavorId = 1;

    service.delete(flavorId).subscribe((message) => {
      expect(message).toBe('Flavor deleted');
    });

    const req = httpMock.expectOne(`${service.API}/delete?id=${flavorId}`);
    expect(req.request.method).toBe('DELETE');
    req.flush('Flavor deleted', { status: 200, statusText: 'OK' });
  });



});
