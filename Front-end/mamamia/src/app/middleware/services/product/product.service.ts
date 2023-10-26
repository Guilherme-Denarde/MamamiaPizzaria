import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Flavor } from 'src/app/models/flavor/flavor';
import { Product } from 'src/app/models/product/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private readonly API: string = 'http://localhost:8080/api/products';

  constructor(private http: HttpClient) { }

  createFlavor(flavor: Flavor): Observable<Flavor> {
    return this.http.post<Flavor>(`${this.API}/flavors`, flavor).pipe(
      catchError(this.handleError)
    );
  }

  getAllFlavors(): Observable<Flavor[]> {
    return this.http.get<Flavor[]>(`${this.API}/flavors/findAll`).pipe(
      catchError(this.handleError)
    );
  }

  updateFlavor(flavor: Flavor): Observable<Flavor> {
    return this.http.put<Flavor>(`${this.API}/flavors/update?id=${flavor.id}`, flavor).pipe(
      catchError(this.handleError)
    );
  }
    
  deleteFlavor(flavorId: number): Observable<string> {
    return this.http.delete(`${this.API}/flavors/delete?id=${flavorId}`, { responseType: 'text' }).pipe(
      catchError(this.handleError)
    );
  }

  createProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(this.API, product).pipe(
      catchError(this.handleError)
    );
  }

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.API}/findAll`).pipe(
      catchError(this.handleError)
    );
  }

  updateProduct(product: Product): Observable<Product> {
    return this.http.put<Product>(`${this.API}/update?id=${product.id}`, product).pipe(
      catchError(this.handleError)
    );
  }
    
  deleteProduct(productId: number): Observable<string> {
    return this.http.delete(`${this.API}/delete?id=${productId}`, { responseType: 'text' }).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: any): Observable<never> {
    console.error('An error occurred:', error);
    return throwError('Something went wrong; please try again later.');
  }
}
