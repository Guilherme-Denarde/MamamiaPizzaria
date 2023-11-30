import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CookieService } from 'ngx-cookie-service';
import { RegisterUserService } from 'src/app/middleware/services/register-user/register-user.service';
import { LoginUser } from 'src/app/models/user/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginUser: LoginUser = {
    email: '',
    password: ''
  };

  constructor(
    private userService: RegisterUserService,
    private router: Router,
    private toastr: ToastrService,
    private cookieService: CookieService
  ) {}

  ngOnInit(): void {
    //Descomente e ele ira limpar os cookies 
    // this.cookieService.deleteAll();
  }

  onLogin() {
    if (!this.loginUser.email || !this.loginUser.password) {
      this.toastr.error('E-mail and password are required!', 'Validation Error');
      return;
    }

    this.userService.login(this.loginUser).subscribe(response => {
      // If the response contains the token object, log it and set the cookie
      if (response && response.access_token) {
        console.log("Login response:", response);
        this.cookieService.set('token', response.access_token, { expires: 1, path: '/' }); 

        // Navigate to the home page
        this.router.navigate(['/home']);

        // Show a success message
        this.toastr.success('Logged in successfully');
      } else {
        // Handle unexpected response structure
        this.toastr.error('Unexpected response received from the server', 'Login Error');
        console.error('Unexpected login response:', response);
      }
      
    }, error => {
      // Handle the error according to the HTTP status code
      if (error.error && error.error.message) {
        this.toastr.error(error.error.message, 'Login Error');
      } else {
        this.toastr.error('Login failed. Please try again.', 'Login Error');
      }
      console.error('Login error response:', error);
    });
  }
}
