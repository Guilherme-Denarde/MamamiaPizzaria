import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { User } from 'src/app/models/user/user';
import { RegisterUserService } from 'src/app/middleware/services/register-user/register-user.service';

@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.scss']
})
export class CadastrarComponent {

  user: User = {
    userId: 1,
    name: '',
    email: '',
    password: '',
    salt: '',
    isActive: false,
    lastLogin: ''
  };

  constructor(
      private userService: RegisterUserService,
      private router: Router,
      private toastr: ToastrService
      ) {} 

  onSubmit() {
    this.user.salt = '';
    this.user.isActive = true;
    this.user.lastLogin = new Date().toISOString();
  
    this.userService.registerUser(this.user)
      .pipe(
        catchError(error => {
          console.error('Error registering user', error);
          
          let errorMessage = error.error ? error.error : 'An unexpected error occurred. Please try again.';
          
          if (errorMessage.includes('email already exists')) {
            this.toastr.error('Email already exists. Please try another email.', 'Registration Error');
          } else if (errorMessage.includes('name already exists')) {
            this.toastr.error('Name already exists. Please try another name.', 'Registration Error');
          } else if (errorMessage.includes('invalid email format') || errorMessage.includes('Email must be a valid address')) {
            this.toastr.error('Invalid email format. Please enter a valid email.', 'Registration Error');
          } else {
            this.toastr.error(errorMessage, 'Registration Error');
          }
        
          return throwError(error);
        })
        
      )
      .subscribe(response => {
        console.log('User registered successfully', response);
        this.router.navigate(['/login']);
      });
  }
}
