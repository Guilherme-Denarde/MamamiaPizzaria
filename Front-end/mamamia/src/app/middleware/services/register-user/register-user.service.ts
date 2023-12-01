import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { LoginUser, User } from 'src/app/models/user/user';
import { CookieService } from 'ngx-cookie-service';
import { jwtDecode } from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class RegisterUserService {

  private readonly API: string = 'http://18.220.122.147:8081/api/users'; 

  constructor(private http: HttpClient, private cookieService: CookieService) { }

  
  registerUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.API}/register`, user).pipe(
      catchError(this.handleError)
    );
  }
  
  login(user: LoginUser): Observable<any> {
    return this.http.post(`${this.API}/authenticate`, user).pipe(
      catchError(this.handleError)
    );
  }

  listAll(): Observable<User[]> {
    return this.http.get<User[]>(`${this.API}/findAll`).pipe(
      catchError(this.handleError)
    );
  }

  save(user: User): Observable<User> {
    return this.registerUser(user);
  }

  edit(user: User): Observable<User> {
    return this.http.put<User>(`${this.API}/update?id=${user.userId}`, user).pipe(
      catchError(this.handleError)
    );
  }
    
  delete(userId: number): Observable<void> {
    return this.http.delete<void>(`${this.API}/delete?id=${userId}`, { responseType: 'text' as 'json' }).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: any): Observable<never> {
    console.error('An error occurred:', error);
    return throwError('Something went wrong; please try again later.');
  }

  getRole(): string | null {
    const token = this.cookieService.get('token');
    if (!token) {
      console.error('No token found in cookies.');
      return null;
    }

    try {
      const decodedToken = jwtDecode<any>(token);
      return decodedToken.role;
    } catch (error) {
      console.error('Error decoding token:', error);
      return null;
    }
  }
}
