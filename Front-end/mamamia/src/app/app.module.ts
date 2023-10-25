import { NgModule } from '@angular/core';
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
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    BrowserAnimationsModule, 
    ToastrModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
