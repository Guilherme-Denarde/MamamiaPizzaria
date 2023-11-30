import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { LoginUser, User } from 'src/app/models/user/user';

@Injectable({
  providedIn: 'root'
})
export class RegisterUserService {

  public API = 'http://localhost:8080/api/users';

  constructor(private http: HttpClient) { }
  
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
}
