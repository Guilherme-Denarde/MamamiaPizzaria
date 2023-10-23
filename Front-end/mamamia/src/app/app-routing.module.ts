import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/sistema/login/login.component';
import { IndexComponent } from './components/layout/index/index.component';
import { ProdutoslistComponent } from './components/produtos/produtoslist/produtoslist.component';
import { PedidoslistComponent } from './components/pedidos/pedidoslist/pedidoslist.component';
import { EntrarComponent } from './components/entrar/entrar.component';
import { CadastrarComponent } from './components/sistema/cadastrar/cadastrar.component';
import { HomePageComponent } from './components/home-page/home-page.component';

const routes: Routes = [
  { path: "", redirectTo: "entrar", pathMatch: 'full' },
  { path: "entrar", component: EntrarComponent },
  { path: "login", component: LoginComponent },
  { path: "produtos", component: ProdutoslistComponent },
  { path: "pedidos", component: PedidoslistComponent },
  { path: "cadastrar", component: CadastrarComponent },
  { path: "home", component: HomePageComponent },
  {
    path: "admin", component: IndexComponent, children: [
      { path: "produtos", component: ProdutoslistComponent },
      { path: "pedidos", component: PedidoslistComponent },
    ]
  },
  {
    path: "restaurante", component: IndexComponent, children: [
      { path: "produtos", component: ProdutoslistComponent },
      { path: "pedidos", component: PedidoslistComponent },
    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
