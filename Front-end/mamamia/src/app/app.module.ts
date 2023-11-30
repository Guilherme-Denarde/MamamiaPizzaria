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
import { RegisterUserDetailsComponent } from './pages/admin/components/register-user/register-userdetails/register-userdetails.component';
import { RegisterUserlistComponent } from './pages/admin/components/register-user/register-userlist/register-userlist.component';
import { ProductListComponent } from './pages/admin/components/product/productlist/productlist.component';
import { OrderlistComponent } from './pages/admin/components/order/orderlist/orderlist.component';
import { ProductDetailsComponent } from './pages/admin/components/product/productdetails/productdetails.component';
import { OrderdetailsComponent } from './pages/admin/components/order/orderdetails/orderdetails.component';
import { EmploylistComponent } from './pages/admin/components/employ/employlist/employlist.component';
import { EmploydetailsComponent } from './pages/admin/components/employ/employdetails/employdetails.component';
import { DeliveryBoylistComponent } from './pages/admin/components/delivery-boy/delivery-boylist/delivery-boylist.component';
import { DeliveryBoydetailsComponent } from './pages/admin/components/delivery-boy/delivery-boydetails/delivery-boydetails.component';
import { ClientlistComponent } from './pages/admin/components/client/clientlist/clientlist.component';
import { ClientdetailsComponent } from './pages/admin/components/client/clientdetails/clientdetails.component';
import { AddresslistComponent } from './pages/admin/components/address/addresslist/addresslist.component';
import { AddressdetailsComponent } from './pages/admin/components/address/addressdetails/addressdetails.component';
import { ReviewlistComponent } from './pages/admin/components/review/reviewlist/reviewlist.component';
import { ReviewdetailsComponent } from './pages/admin/components/review/reviewdetails/reviewdetails.component';
import { FlavorListComponent } from './pages/admin/components/flavor/flavorlist/flavorlist.component';
import { FlavorDetailsComponent } from './pages/admin/components/flavor/flavordetails/flavordetails.component';
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
import { CategorySelectorComponent } from './pages/shared/components/category-selector/category-selector.component';
import { PaymentFormComponent } from './pages/shared/components/payment-form/payment-form.component';

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
    PaymentFormComponent
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
