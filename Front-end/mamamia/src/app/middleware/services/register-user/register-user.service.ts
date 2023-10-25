import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginUser, User } from 'src/app/models/user/user';

@Injectable({
  providedIn: 'root'
})
export class RegisterUserService {

  API: string = 'http://localhost:8080/api/users'; 

  constructor(private http: HttpClient) { }
  
  registerUser(user: User): Observable<User> {
    return this.http.post<User>(this.API + '/register', user);
  }
  
  login(user: LoginUser): Observable<any> {
    const loginEndpoint = `${this.API}/login`;
    return this.http.post(loginEndpoint, user);
  }

  listAll(): Observable<User[]> {
    return this.http.get<User[]>(this.API + '/findAll');
  }

  save(user: User): Observable<User> {
    return this.http.post<User>(this.API, user);
  }

  exemploErro(): Observable<User[]> {
    return this.http.get<User[]>(this.API + '/erro');
  }

  edit(user: User): Observable<User> {
    return this.http.put<User>(`${this.API}/${user.id}`, user);
  }
    
  delete(userId: number): Observable<void> {
    return this.http.delete<void>(`${this.API}/${userId}`);
  }

}
