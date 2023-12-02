import { TestBed } from '@angular/core/testing';

import { RegisterUserService } from './register-user.service';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { LoginUser, User } from 'src/app/models/user/user';

describe('RegisterUserService', () => {
  let service: RegisterUserService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        MatSnackBarModule,HttpClientTestingModule
      ],
    });
    service = TestBed.inject(RegisterUserService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify(); // Verifica se todas as solicitações foram tratadas
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should register a user', () => {
    const user: User = { 
      userId: 1,
      name: 'John Doe',
      email: 'john.doe@example.com',
      password: 'password123',
      isActive: true,
      lastLogin: '2023-11-30T12:00:00Z',
      role: 'user'
    };
    
    service.registerUser(user).subscribe((response) => {
      expect(response).toEqual(user); // Verifique se a resposta é o mesmo objeto de usuário
    });
    
    const req = httpMock.expectOne(`${service.API}/register`);
    expect(req.request.method).toBe('POST');
    req.flush(user); // Simula uma resposta bem-sucedida
  });

  it('should handle registration errors', () => {
    const user: User = { 
      userId: 1,
      name: 'John Doe',
      email: 'john.doe@example.com',
      password: 'password123',
      isActive: true,
      lastLogin: '2023-11-30T12:00:00Z',
      role: 'user'
    };
    
    service.registerUser(user).subscribe(
      () => fail('Expected an error, but got a successful response'),
      (error) => {
        expect(error).toBeTruthy(); // Verifique se ocorreu um erro
      }
    );

    const req = httpMock.expectOne(`${(service as any).API}/register`);
    expect(req.request.method).toBe('POST');
    req.error(new ErrorEvent('Network error', { message: 'Failed to connect' })); // Simula um erro de rede
  });

  it('should handle login errors', () => {
    const loginUser: LoginUser = {
      email: 'john.doe@example.com',
      password: 'invalidPassword',
    };
  
    service.login(loginUser).subscribe(
      () => fail('Expected an error, but got a successful response'),
      (error) => {
        expect(error).toBeTruthy(); 
      }
    );
  
    const req = httpMock.expectOne(`${service.API}/authenticate`);
    expect(req.request.method).toBe('POST');
    req.error(new ErrorEvent('Network error', { message: 'Failed to connect' })); // Simula um erro de rede
  });

  it('should delete a user', () => {
    const userIdToDelete = 1; // Preencha com o ID do usuário a ser excluído
  
    service.delete(userIdToDelete).subscribe(() => {
      // Verifique se a exclusão ocorreu sem erros
      expect(true).toBeTruthy();
    });
  
    const req = httpMock.expectOne(`${service.API}/delete?id=${userIdToDelete}`);
    expect(req.request.method).toBe('DELETE');
    req.flush({}); // Simula uma resposta vazia para a exclusão bem-sucedida
  });
  


});
