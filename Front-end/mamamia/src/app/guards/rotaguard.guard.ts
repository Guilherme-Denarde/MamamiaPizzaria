import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { RegisterUserService } from '../middleware/services/register-user/register-user.service';

export const rotaguardGuard: CanActivateFn = (route, state) => {

  let loginService = inject(RegisterUserService);
  let roteador = inject(Router);

  if (loginService.getToken() == null) {
    roteador.navigate(['/login']);
    return false;
  } else
    return true;

};