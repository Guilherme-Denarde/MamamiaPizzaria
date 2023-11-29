import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { RegisterUserService } from 'src/app/middleware/services/register-user/register-user.service';
import { LoginUser } from 'src/app/models/user/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  loginUser : LoginUser = {
    email: '',
    password: ''
  };

  constructor(
    private userService: RegisterUserService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  onLogin() {
    this.userService.login(this.loginUser).subscribe(response => {
      // Assuming the response contains a token you need to store
      localStorage.setItem('token', response.token);
      this.router.navigate(['/home']);
      this.toastr.success('Logged in successfully');
    }, error => {
      // More specific error handling if you have different cases to handle
      if (error.status === 401) {
        this.toastr.error('Incorrect email or password.', 'Authentication Failed');
      } else {
        this.toastr.error('An unexpected error occurred. Please try again later.', 'Login Error');
      }
      console.error('Login error response:', error);
    });
  }
  
}
