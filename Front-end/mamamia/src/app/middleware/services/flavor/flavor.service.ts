import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Flavor } from 'src/app/models/flavor/flavor';

@Injectable({
  providedIn: 'root'
})
export class FlavorService {

  private readonly API: string = 'http://localhost:8080/api/flavors'; 

  constructor(private http: HttpClient) { }

  create(flavor: Flavor): Observable<Flavor> {
    return this.http.post<Flavor>(this.API, flavor).pipe(
      catchError(this.handleError)
    );
  }

  getAll(): Observable<Flavor[]> {
    return this.http.get<Flavor[]>(`${this.API}/findAll`).pipe(
      catchError(this.handleError)
    );
  }

  update(flavor: Flavor): Observable<Flavor> {
    return this.http.put<Flavor>(`${this.API}/update?id=${flavor.id}`, flavor).pipe(
      catchError(this.handleError)
    );
  }
    
  delete(flavorId: number): Observable<string> {
    return this.http.delete(`${this.API}/delete?id=${flavorId}`, { responseType: 'text' }).pipe(
      catchError(this.handleError)
    );
}

  private handleError(error: any): Observable<never> {
    console.error('An error occurred:', error);
    return throwError('Something went wrong; please try again later.');
  }
}
