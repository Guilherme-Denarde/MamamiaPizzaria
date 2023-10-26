import { Injectable, inject } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from 'src/app/models/product/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  API = 'http://localhost:8080/api/products';
  http = inject(HttpClient);

  constructor() { }


  listAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.API + '/findAll');
  }

  save(produto: Product): Observable<Product> {
    return this.http.post<Product>(this.API, produto);
  }

  exemploErro(): Observable<Product[]> {
    return this.http.get<Product[]>(this.API + '/erro');
  }

}