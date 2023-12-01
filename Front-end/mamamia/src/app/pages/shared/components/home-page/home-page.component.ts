import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  lista: any[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.onSearch('');
  }
  
  onSearch(term: string) {
    let url = 'http://18.220.122.147:8081/api/products/findAll';
    if(term.trim() !== '') {
      url = `http://18.220.122.147:8081/api/products/search?name=${term}`;
    }

    this.http.get<any[]>(url).subscribe(
      data => {
        this.lista = data;
      },
      error => {
        console.error('Erro ao buscar produtos:', error);
      }
    );
  }
}
