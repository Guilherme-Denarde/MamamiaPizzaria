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
  sortDirection: string = 'asc';
  showDateFilter: boolean = false;
  currentYear: number = new Date().getFullYear();
  months: string[] = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
  selectedMonth: string | null = null;

  constructor(private modalService: NgbModal, private userService: RegisterUserService) { }

  ngOnInit(): void {
    this.listAll();
  }

  listAll() {
    
    this.userService.listAll().subscribe({
      next: data => {
        this.lista = data;
        this.sortList(); 
      },
      error: error => {
        console.error('Error:', error);
        alert('An error occurred. Please check the console for more details.');
      }
    });
  }

  sortList() {
    this.lista.sort((a, b) => b.userId - a.userId);
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
  	console.log(user.userId);
    
    if (!this.isValidName || !this.isValidEmail) {
      alert('Por favor, insira dados válidos.');
      return;
    }

    const userObservable = (user.userId === null || user.userId === undefined) ? 
                       this.userService.save(user) : 
                       this.userService.edit(user);

    
    userObservable.subscribe({
        next: responseUser => {
            if (user.userId) {
                this.lista[this.indiceSelecionadoParaEdicao] = responseUser;
                alert('Usuário editado com sucesso!');
            } else {
                this.lista.unshift(responseUser);
                alert('Usuário adicionado com sucesso!');
            }
        },
        error: erro => {
            const action = user.userId ? "editar" : "adicionar";
            alert(`Ocorreu um erro ao tentar ${action} o usuário.`);
            console.error(erro);
        }
    });

    this.modalService.dismissAll();
  }

delete(user: User, index: number) {
  if (!user.userId) { 
    console.error('User ID is undefined or null. Cannot delete user.');
    alert('Error: Cannot delete user without a valid ID.');
    return;
  }
  
  if (confirm('Você tem certeza de que deseja deletar este usuário?')) {
    this.userService.delete(user.userId).subscribe({
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
  sortByName(): void {
    if (this.sortDirection === 'asc') {
      this.lista.sort((a, b) => a.name.localeCompare(b.name));
      this.sortDirection = 'desc';
    } else {
      this.lista.sort((a, b) => b.name.localeCompare(a.name));
      this.sortDirection = 'asc';
    }
  }

  sortByEmail(): void {
    if (this.sortDirection === 'asc') {
      this.lista.sort((a, b) => a.email.localeCompare(b.email));
      this.sortDirection = 'desc';
    } else {
      this.lista.sort((a, b) => b.email.localeCompare(a.email));
      this.sortDirection = 'asc';
    }
  }
  toggleDateFilter(): void {
    this.showDateFilter = !this.showDateFilter;
  }

  prevYear(): void {
    this.currentYear--;
  }

  nextYear(): void {
    this.currentYear++;
  }

  filterByMonth(month: string): void {
    this.selectedMonth = month;
    const monthIndex = this.months.indexOf(month);
    this.lista = this.lista.filter(user => {
      const date = new Date(user.lastLogin);
      return date.getFullYear() === this.currentYear && date.getMonth() === monthIndex;
    });
  }

}
