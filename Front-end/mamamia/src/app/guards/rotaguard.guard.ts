// import { inject } from '@angular/core';
// import { CanActivateFn, Router } from '@angular/router';
// import { RegisterUserService } from '../middleware/services/register-user/register-user.service';

// export const rotaguardGuard: CanActivateFn = (route, state) => {

//   let loginService = inject(RegisterUserService);
//   let roteador = inject(Router);

//   if (loginService.getToken() == null) {
//     roteador.navigate(['/login']);
//     return false;
//   } else
//     return true;

// };
import { CanActivate, ActivatedRouteSnapshot, Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { RegisterUserService } from '../middleware/services/register-user/register-user.service';
import {jwtDecode} from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class RotaguardGuard implements CanActivate {

  constructor(private registerUserService: RegisterUserService, private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot): boolean {
    const token = this.registerUserService.getToken();

    if (!token) {
      this.router.navigate(['/login']);
      return false;
    }

    try {
      const decodedToken = jwtDecode<any>(token);
      const userRole = decodedToken.role;
      const requiredRoles = route.data['roles'] as Array<string>;

      if (requiredRoles.includes(userRole)) {
        return true;
      } else {
        this.router.navigate(['/']); // Redirect to a different route if user role doesn't match
        return false;
      }
    } catch (error) {
      console.error('Error decoding token:', error);
      this.router.navigate(['/login']);
      return false;
    }
  }
}
