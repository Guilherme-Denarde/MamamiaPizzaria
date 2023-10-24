import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EntrarComponent } from './modules/user/components/entrar/entrar.component';
import { LoginComponent } from './modules/user/components/sistema/login/login.component';
import { CadastrarComponent } from './modules/user/components/sistema/cadastrar/cadastrar.component';
import { HomePageComponent } from './modules/user/components/home-page/home-page.component';
import { IndexComponent } from './modules/user/components/layout/index/index.component';

const routes: Routes = [
  { path: "", redirectTo: "entrar", pathMatch: 'full' },
  { path: "entrar", component: EntrarComponent },
  { path: "login", component: LoginComponent },
  { path: "cadastrar", component: CadastrarComponent },
  { path: "home", component: HomePageComponent },
  {
    path: "admin", component: IndexComponent, children: [
    ]
  },
  {
    path: "restaurante", component: IndexComponent, children: [
    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
