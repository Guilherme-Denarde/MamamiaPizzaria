import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { AuthGuard } from './guards/rotaguard.guard';
import { HomePageComponent } from './components/client/home-page/home-page.component';
import { CadastrarComponent } from './components/client/cadastrar/cadastrar.component';
import { LoginComponent } from './components/client/login/login.component';
import { NotFoundComponent } from './components/client/not-found/not-found.component';
import { IndexComponent } from './components/layout/index/index.component';
import { RegisterUserlistComponent } from './components/manager/register-user/register-userlist/register-userlist.component';
import { FlavorListComponent } from './components/manager/flavor/flavorlist/flavorlist.component';
import { ProductListComponent } from './components/manager/product/productlist/productlist.component';
import { AdminOrdersComponent } from './components/client/admin-orders/admin-orders.component';

const routes: Routes = [
  { path: "", redirectTo: "signup", pathMatch: 'full' },
  { path: "login", component: LoginComponent },
  { path: "signup", component: CadastrarComponent },
  { path: "home", component: HomePageComponent },
  { path: '404', component: NotFoundComponent },
  {
    path: "admin",
    canActivate: [AuthGuard],
    component: IndexComponent,
    children: [
      { path: "registeruser", component: RegisterUserlistComponent },
      { path: "flavor", component: FlavorListComponent },
      { path: "product", component: ProductListComponent },
      {path: "orders", component: AdminOrdersComponent}
    ]
  },
  {
    path: "user",
    canActivate: [AuthGuard],
    component: IndexComponent,
    children: [
      { path: "registeruser", component: RegisterUserlistComponent },
      { path: "flavor", component: FlavorListComponent },
    ]
  },
  {
    path: "restaurante", component: IndexComponent, children: [
    ]
  },
  { path: '**', redirectTo: '/404' },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule],
  providers: [CookieService]
})
export class AppRoutingModule { 

}
