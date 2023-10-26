import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  template: `
     <app-search-bar (search)="onSearch($event)"></app-search-bar>
    <app-product-list [products]="products"></app-product-list>
  `,
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Mamamia';


  


}
