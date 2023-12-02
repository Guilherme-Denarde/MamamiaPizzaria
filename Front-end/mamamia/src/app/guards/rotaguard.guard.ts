import { CanActivate, Router } from '@angular/router';
import { RegisterUserService } from 'src/app//services/register-user/register-user.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router, private userService: RegisterUserService) {}

  canActivate(): boolean {
    const role = this.userService.getRole();
    if (!role) {
      this.router.navigate(['/login']);
      return false;
    }

    if (role === 'ADMIN' || role === 'MANAGER') {      
      return true;
    } else if (role === 'CLIENTE') {
      this.router.navigate(['/home']);
      return false;
    } else {
      this.router.navigate(['/entrar']);
      return false;
    }

    return true;
  }
}
