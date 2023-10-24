import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './modules/user/components/layout/header/header.component';
import { FooterComponent } from './modules/user/components/layout/footer/footer.component';
import { IndexComponent } from './modules/user/components/layout/index/index.component';
import { LoginComponent } from './modules/user/components/sistema/login/login.component';
import { PerfilComponent } from './modules/user/components/perfil/perfil.component';
import { EntrarComponent } from './modules/user/components/entrar/entrar.component';
import { HomePageComponent } from './modules/user/components/home-page/home-page.component';
import { CadastrarComponent } from './modules/user/components/sistema/cadastrar/cadastrar.component';
import { ProductCardComponent } from './modules/shared/product-card/product-card.component';

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
