import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ToastrService, ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CadastrarComponent } from './cadastrar.component';
import { HttpClientTestingModule } from '@angular/common/http/testing'; 
import { FormsModule } from '@angular/forms';

const mockToastrService = {
  success: jasmine.createSpy('success'),
  error: jasmine.createSpy('error')
};

describe('CadastrarComponent', () => {
  let component: CadastrarComponent;
  let fixture: ComponentFixture<CadastrarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CadastrarComponent],
      imports: [
        ToastrModule.forRoot(), 
        BrowserAnimationsModule,
        HttpClientTestingModule,
        FormsModule
      ],
      providers: [
        { provide: ToastrService, useValue: mockToastrService } 
      ]
    });
    fixture = TestBed.createComponent(CadastrarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
