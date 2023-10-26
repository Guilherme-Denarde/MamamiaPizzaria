import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { RegisterUserlistComponent } from './components/register-user/register-userlist/register-userlist.component';
import { ProductlistComponent } from './components/product/productlist/productlist.component';
import { ProductdetailsComponent } from './components/product/productdetails/productdetails.component';
import { OrderdetailsComponent } from './components/order/orderdetails/orderdetails.component';
import { OrderlistComponent } from './components/order/orderlist/orderlist.component';
import { FlavorlistComponent } from './components/flavor/flavorlist/flavorlist.component';
import { FlavordetailsComponent } from './components/flavor/flavordetails/flavordetails.component';
import { EmploydetailsComponent } from './components/employ/employdetails/employdetails.component';
import { EmploylistComponent } from './components/employ/employlist/employlist.component';
import { DeliveryBoylistComponent } from './components/delivery-boy/delivery-boylist/delivery-boylist.component';
import { DeliveryBoydetailsComponent } from './components/delivery-boy/delivery-boydetails/delivery-boydetails.component';
import { ClientdetailsComponent } from './components/client/clientdetails/clientdetails.component';
import { ClientlistComponent } from './components/client/clientlist/clientlist.component';
import { AddresslistComponent } from './components/address/addresslist/addresslist.component';
import { AddressdetailsComponent } from './components/address/addressdetails/addressdetails.component';
import { ReviewlistComponent } from './components/review/reviewlist/reviewlist.component';
import { RegisterUserDetailsComponent } from './components/register-user/register-userdetails/register-userdetails.component';
import { ReviewdetailsComponent } from './components/review/reviewdetails/reviewdetails.component';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';


@NgModule({
  declarations: [
    
     
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule,
    BrowserModule,
  ]
})
export class AdminModule { }
