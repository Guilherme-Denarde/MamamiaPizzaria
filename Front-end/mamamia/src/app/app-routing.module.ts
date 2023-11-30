import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/public/components/login/login.component';
import { CadastrarComponent } from './pages/public/components/sistema/cadastrar/cadastrar.component';
import { HomePageComponent } from './pages/shared/components/home-page/home-page.component';
import { IndexComponent } from './pages/shared/layout/index/index.component';
import { RegisterUserlistComponent } from './pages/admin/components/register-user/register-userlist/register-userlist.component';
import { FlavorListComponent } from './pages/admin/components/flavor/flavorlist/flavorlist.component';
import { ProductListComponent } from './pages/admin/components/product/productlist/productlist.component';
import { CookieService } from 'ngx-cookie-service';
import { PageNotFoundComponent } from './pages/public/components/page-not-found/page-not-found.component';
import { RotaguardGuard } from './guards/rotaguard.guard';

const routes: Routes = [
  { path: "", redirectTo: "signup", pathMatch: 'full' },
  { path: "login", component: LoginComponent },
  { path: "signup", component: CadastrarComponent },
  { path: "home", component: HomePageComponent },
  { path: '404', component: PageNotFoundComponent },
  { path: '**', redirectTo: '/404' },
  { path: "registeruser", component: RegisterUserlistComponent },
  {
    path: "admin",
    // canActivate: [RotaguardGuard],
    // data: { roles: ['MANAGER', 'ADMIN'] },
    component: IndexComponent,
     children: [
      { path: "registeruser", component: RegisterUserlistComponent },
      { path: "flavor", component: FlavorListComponent },
      { path: "product", component: ProductListComponent },
      { path: "home", component: HomePageComponent },

    ]
  },
  {
    path: "user",
    canActivate: [RotaguardGuard],
    data: { roles: ['CLIENTE'] },
    component: IndexComponent,
      children: [
      { path: "registeruser", component: RegisterUserlistComponent },
      { path: "flavor", component: FlavorListComponent },
      { path: "home", component: HomePageComponent },

    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [CookieService]
})
export class AppRoutingModule { }
