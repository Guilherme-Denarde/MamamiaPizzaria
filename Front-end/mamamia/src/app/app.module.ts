import {CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTabsModule } from '@angular/material/tabs';
import { MatSnackBarModule } from '@angular/material/snack-bar';

import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { HeaderComponent } from './components/layout/header/header.component';
import { FooterComponent } from './components/layout/footer/footer.component';
import { IndexComponent } from './components/layout/index/index.component';
import { LoginComponent } from './components/client/login/login.component';
import { PerfilComponent } from './components/client/perfil/perfil.component';
import { HomePageComponent } from './components/client/home-page/home-page.component';
import { CadastrarComponent } from './components/client/cadastrar/cadastrar.component';
import { ProductCardComponent } from './components/client/product-card/product-card.component';
import { RegisterUserDetailsComponent } from './components/manager/register-user/register-userdetails/register-userdetails.component';
import { RegisterUserlistComponent } from './components/manager/register-user/register-userlist/register-userlist.component';
import { ProductListComponent } from './components/manager/product/productlist/productlist.component';
import { ProductDetailsComponent } from './components/manager/product/productdetails/productdetails.component';
import { OrderlistComponent } from './components/manager/order/orderlist/orderlist.component';
import { OrderdetailsComponent } from './components/manager/order/orderdetails/orderdetails.component';
import { FlavorListComponent } from './components/manager/flavor/flavorlist/flavorlist.component';
import { FlavorDetailsComponent } from './components/manager/flavor/flavordetails/flavordetails.component';
import { EmploylistComponent } from './components/manager/employ/employlist/employlist.component';
import { EmploydetailsComponent } from './components/manager/employ/employdetails/employdetails.component';
import { DeliveryBoylistComponent } from './components/manager/delivery-boy/delivery-boylist/delivery-boylist.component';
import { DeliveryBoydetailsComponent } from './components/manager/delivery-boy/delivery-boydetails/delivery-boydetails.component';
import { ClientlistComponent } from './components/manager/client/clientlist/clientlist.component';
import { ClientdetailsComponent } from './components/manager/client/clientdetails/clientdetails.component';
import { AddresslistComponent } from './components/manager/address/addresslist/addresslist.component';
import { AddressdetailsComponent } from './components/manager/address/addressdetails/addressdetails.component';
import { ReviewlistComponent } from './components/manager/review/reviewlist/reviewlist.component';
import { ReviewdetailsComponent } from './components/manager/review/reviewdetails/reviewdetails.component';
import { SearchBarComponent } from './components/client/search-bar/search-bar.component';
import { FoodItemSliderComponent } from './components/client/food-item-slider/food-item-slider.component';
import { StoreListComponent } from './components/client/store-list/store-list.component';
import { OrdersListComponent } from './components/client/orders-list/orders-list.component';
import { PedidoFormComponent } from './components/layout/pedido-form/pedido-form.component';
import { CategorySelectorComponent } from './components/client/category-selector/category-selector.component';
import { PaymentFormComponent } from './components/client/payment-form/payment-form.component';
import { AdminOrdersComponent } from './components/client/admin-orders/admin-orders.component';
import { AdminHeaderComponent } from './components/manager/admin-header/admin-header.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    IndexComponent,
    LoginComponent,
    PerfilComponent,
    HomePageComponent,
    CadastrarComponent,
    ProductCardComponent,
    RegisterUserDetailsComponent,
    RegisterUserlistComponent,
    ProductListComponent,
    ProductDetailsComponent,
    OrderlistComponent,
    OrderdetailsComponent,
    FlavorListComponent,
    FlavorDetailsComponent,
    EmploylistComponent,
    EmploydetailsComponent,
    DeliveryBoylistComponent,
    DeliveryBoydetailsComponent,
    ClientlistComponent,
    ClientdetailsComponent,
    AddresslistComponent,
    AddressdetailsComponent,
    ReviewlistComponent,
    ReviewdetailsComponent,
    SearchBarComponent,
    FoodItemSliderComponent,
    StoreListComponent,
    OrdersListComponent,
    PedidoFormComponent,
    CategorySelectorComponent,
    PaymentFormComponent,
    AdminOrdersComponent,
    AdminHeaderComponent,
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
    MatIconModule,
    
 ],
 
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
