import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginUser, User } from 'src/app/modules/models/user/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private API: string = 'http://localhost:8080/api/users'; 

  constructor(private http: HttpClient) { }  

  registerUser(user: User): Observable<User> {
    return this.http.post<User>(this.API, user);
  }

//   async login(user: LoginUser): Promise<any> {
//     const loginEndpoint = `${this.API}/login`;
//     try {
//         const result = await this.http.post(loginEndpoint, { email: user.email, password: user.password }).toPromise();
//         return result;
//     } catch (error) {
//         throw error;
//     }    
// }

login(user: LoginUser): Observable<any> {
  const loginEndpoint = `${this.API}/login`;
  return this.http.post(loginEndpoint, user);
}


}
