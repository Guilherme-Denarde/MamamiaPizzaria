import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';

import { CookieService } from 'ngx-cookie-service';


@Injectable({
  providedIn: 'root'
})
export class ClientService {



  
  API = 'http://localhost:8081/api/clients';
  http = inject(HttpClient);

  constructor(private cookieService: CookieService) {}



   token = this.cookieService.get('token');
   headers = new HttpHeaders({ 'Authorization': `Bearer ${this.token}` });



   me() { 


    return this.http.get(`${this.API}/me`, {headers: this.headers});
  

   }









}
