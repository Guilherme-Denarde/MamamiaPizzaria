import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { RegisterUserService } from 'src/app/middleware/services/register-user/register-user.service';
import { User } from 'src/app/models/user/user';

@Component({
  selector: 'app-register-user-details',
  templateUrl: './register-userdetails.component.html',
  styleUrls: ['./register-userdetails.component.scss']
})
export class RegisterUserDetailsComponent {

  @Input() registerUser: User = new User();  
  @Output() retorno = new EventEmitter<User>(); 


  constructor(private userService: RegisterUserService) { }

  salvar() {
    this.userService.save(this.registerUser).subscribe({  
      next: user => { 
        this.retorno.emit(user);
      },
      error: erro => { 
        alert('Exemplo de tratamento de erro/exception! Observe o erro no console!');
        console.error(erro);
      }
    });
  }
}
