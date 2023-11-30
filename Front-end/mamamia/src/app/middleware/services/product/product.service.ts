import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Flavor } from 'src/app/models/flavor/flavor';
import { Product } from 'src/app/models/product/product';
import { CookieService } from 'ngx-cookie-service';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] = [];

  private readonly API: string = 'http://localhost:8080/api/products';

  constructor(private cookieService: CookieService,private http: HttpClient) { }

  public getHeaders(): HttpHeaders {
    const token = this.cookieService.get('token');
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`
    }); 
  }

  createFlavor(flavor: Flavor): Observable<Flavor> {
    return this.http.post<Flavor>(`${this.API}/flavors`, flavor, { headers: this.getHeaders() }).pipe(
      catchError(this.handleError)
    );
  }

  getAllFlavors(): Observable<Flavor[]> {
    return this.http.get<Flavor[]>(`${this.API}/flavors/findAll`, { headers: this.getHeaders() }).pipe(
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
    return this.http.post<Product>(this.API, product,  { headers: this.getHeaders() }).pipe(
      catchError(this.handleError)
    );
  }

// In ProductService
getAllProducts(): Observable<Product[]> {
  return this.http.get<Product[]>(`${this.API}/findAll`, { headers: this.getHeaders() }).pipe(
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