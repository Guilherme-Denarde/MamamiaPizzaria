import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Flavor } from 'src/app/models/flavor/flavor';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class FlavorService {

  private readonly API: string = 'http://localhost:8080/sabor';

  constructor(private cookieService: CookieService,private http: HttpClient) { }

  public getHeaders(): HttpHeaders {
    const token = this.cookieService.get('token');
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`
    }); 
  }

  createFlavor(flavor: Flavor): Observable<Flavor> {
    return this.http.post<Flavor>(`${this.API}`, flavor, { headers: this.getHeaders() }).pipe(
      catchError(this.handleError)
    );
  }

  getAllFlavors(): Observable<Flavor[]> {
    return this.http.get<Flavor[]>(`${this.API}/findall`, { headers: this.getHeaders() }).pipe(
      catchError(this.handleError)
    );
  }

  updateFlavor(flavor: Flavor): Observable<Flavor> {
    return this.http.put<Flavor>(`${this.API}/update?id=${flavor.id}`, flavor).pipe(
      catchError(this.handleError)
    );
  }
    
  deleteFlavor(flavorId: number): Observable<string> {
    return this.http.delete(`${this.API}?id=${flavorId}`, { responseType: 'text' }).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: any): Observable<never> {
    console.error('An error occurred:', error);
    return throwError('Something went wrong; please try again later.');
  }
}
