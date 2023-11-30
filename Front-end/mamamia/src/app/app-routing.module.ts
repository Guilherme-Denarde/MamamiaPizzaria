import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EntrarComponent } from './pages/shared/components/entrar/entrar.component';
import { LoginComponent } from './pages/public/components/login/login.component';
import { CadastrarComponent } from './pages/public/components/sistema/cadastrar/cadastrar.component';
import { HomePageComponent } from './pages/shared/components/home-page/home-page.component';
import { IndexComponent } from './pages/shared/layout/index/index.component';
import { RegisterUserlistComponent } from './pages/admin/components/register-user/register-userlist/register-userlist.component';
import { FlavorListComponent } from './pages/admin/components/flavor/flavorlist/flavorlist.component';
import { ProductListComponent } from './pages/admin/components/product/productlist/productlist.component';
import { CookieService } from 'ngx-cookie-service';
import { AdminOrdersComponent } from './pages/shared/components/admin-orders/admin-orders.component';
import { NotFoundComponent } from './pages/public/components/not-found/not-found.component';
import { AuthGuard } from './guards/rotaguard.guard';

const routes: Routes = [
  { path: "", redirectTo: "entrar", pathMatch: 'full' },
  { path: "entrar", component: EntrarComponent },
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
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [CookieService]
})
export class AppRoutingModule { 

}
