import { Component, inject } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { RegisterUserService } from 'src/app/middleware/services/register-user/register-user.service';
import { User } from 'src/app/models/user/user';

@Component({
  selector: 'app-userslist',
  templateUrl: './register-userlist.component.html',
  styleUrls: ['./register-userlist.component.scss']
})
export class RegisterUserlistComponent {
  
  lista: User[] = [];
  isValidName: boolean = true;
  isValidEmail: boolean = true;

  selectedUserForEdit: User = new User();
  indiceSelecionadoParaEdicao!: number;

  constructor(private modalService: NgbModal, private userService: RegisterUserService) { }

  ngOnInit(): void {
    this.listAll();
  }

  listAll() {
    this.userService.listAll().subscribe({
        next: data => {
            this.lista = data;
        },
        error: error => {
            console.error('Error:', error);
            alert('An error occurred. Please check the console for more details.');
        }
    });
}

  adicionar(modal: any) {
    this.selectedUserForEdit = new User();
    this.modalService.open(modal, { size: 'sm' });
  }

  editar(modal: any, user: User, indice: number) {
    this.selectedUserForEdit = Object.assign({}, user);
    this.indiceSelecionadoParaEdicao = indice;
    this.modalService.open(modal, { size: 'sm' });
  }

  addOuEditarUser(user: User) {
    this.validateName(user.name);
    this.validateEmail(user.email);

    if (!this.isValidName || !this.isValidEmail) {
      alert('Por favor, insira dados válidos.');
      return;
    }

    if (user.id) { 
      this.userService.edit(user).subscribe({
          next: editedUser => {
              this.lista[this.indiceSelecionadoParaEdicao] = editedUser;
              alert('Usuário editado com sucesso!');
          },
          error: erro => {
              alert('Ocorreu um erro ao tentar editar o usuário.');
              console.error(erro);
          }
      });
    } else {
      this.userService.save(user).subscribe({
          next: savedUser => {
              this.lista.push(savedUser);
              alert('Usuário adicionado com sucesso!');
          },
          error: erro => {
              alert('Ocorreu um erro ao tentar adicionar o usuário.');
              console.error(erro);
          }
      });
    }

    this.modalService.dismissAll();
  }

  delete(id: number, index: number) {
    if (confirm('Você tem certeza de que deseja deletar este usuário?')) {
      this.userService.delete(id).subscribe({
        next: () => {
          this.lista.splice(index, 1);
          alert('Usuário deletado com sucesso!');
        },
        error: erro => {
          alert('Ocorreu um erro ao tentar deletar o usuário.');
          console.error(erro);
        }
      });
    }
  }

  validateName(name: string): void {
    this.isValidName = !!name; 
  }
  
  validateEmail(email: string): void {
    this.isValidEmail = !!email; 
  }
}
