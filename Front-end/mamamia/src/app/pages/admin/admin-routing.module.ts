import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from '../shared/layout/index/index.component';
import { RegisterUserlistComponent } from './components/register-user/register-userlist/register-userlist.component';

const routes: Routes = [
  // {
  //   path: "admin", component: IndexComponent, children: [
  //     { path: "registeruser", component: RegisterUserlistComponent },
  //   ]
  // }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
