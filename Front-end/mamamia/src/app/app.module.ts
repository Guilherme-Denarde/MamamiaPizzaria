import {CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './pages/shared/layout/header/header.component';
import { FooterComponent } from './pages/shared/layout/footer/footer.component';
import { IndexComponent } from './pages/shared/layout/index/index.component';
import { PerfilComponent } from './pages/user/components/perfil/perfil.component';
import { LoginComponent } from './pages/public/components/login/login.component';
import { HomePageComponent } from './pages/shared/components/home-page/home-page.component';
import { EntrarComponent } from './pages/shared/components/entrar/entrar.component';
import { CadastrarComponent } from './pages/public/components/sistema/cadastrar/cadastrar.component';
import { ProductCardComponent } from './pages/shared/product-card/product-card.component';
import { SearchBarComponent } from './pages/public/components/search-bar/search-bar.component';
import { FoodItemSliderComponent } from './pages/public/components/food-item-slider/food-item-slider.component';
import { StoreListComponent } from './pages/public/components/store-list/store-list.component';
import { MatTabsModule } from '@angular/material/tabs';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { OrdersListComponent } from './pages/public/components/orders-list/orders-list.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { PedidoFormComponent } from './pages/shared/layout/pedido-form/pedido-form.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    IndexComponent,
    LoginComponent,
    PerfilComponent,
    HomePageComponent,
    EntrarComponent,
    CadastrarComponent,
    ProductCardComponent,
    SearchBarComponent,
    FoodItemSliderComponent,
    StoreListComponent,
    OrdersListComponent,
    PedidoFormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    BrowserAnimationsModule, 
    ToastrModule.forRoot(),
    MatTabsModule,
    MatSnackBarModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
