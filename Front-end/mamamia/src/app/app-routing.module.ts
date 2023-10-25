import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EntrarComponent } from './pages/shared/components/entrar/entrar.component';
import { LoginComponent } from './pages/public/components/login/login.component';
import { CadastrarComponent } from './pages/public/components/sistema/cadastrar/cadastrar.component';
import { HomePageComponent } from './pages/shared/components/home-page/home-page.component';
import { IndexComponent } from './pages/shared/layout/index/index.component';
import { RegisterUserlistComponent } from './pages/admin/components/register-user/register-userlist/register-userlist.component';

const routes: Routes = [
  { path: "", redirectTo: "entrar", pathMatch: 'full' },
  { path: "entrar", component: EntrarComponent },
  { path: "login", component: LoginComponent },
  { path: "cadastrar", component: CadastrarComponent },
  { path: "home", component: HomePageComponent },
  {
    path: "admin", component: IndexComponent, children: [
      { path: "registeruser", component: RegisterUserlistComponent },
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
