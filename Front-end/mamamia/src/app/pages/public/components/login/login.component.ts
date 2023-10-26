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
      this.router.navigate(['/home']);
    }, error => {
      if (error.error && error.error.message) {
        this.toastr.error(error.error.message, 'Login Error');
      } else {
        this.toastr.error('Login failed. Please try again.', 'Login Error');
        console.error('Full error object:', error);


      }
    });
  }
}
