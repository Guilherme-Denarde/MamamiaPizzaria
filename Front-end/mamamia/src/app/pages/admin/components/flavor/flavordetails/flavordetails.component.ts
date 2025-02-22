import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FlavorService } from 'src/app/middleware/services/flavor/flavor.service';
import { Flavor } from 'src/app/models/flavor/flavor';

@Component({
  selector: 'app-flavordetails',
  templateUrl: './flavordetails.component.html',
  styleUrls: ['./flavordetails.component.scss']
})
export class FlavorDetailsComponent {

  @Input() flavor: Flavor = new Flavor();
  @Output() retorno = new EventEmitter<Flavor>(); 

  constructor(private flavorService: FlavorService) { }

  saveFlavor() {
    const flavorObservable = this.flavor.id ? 
                             this.flavorService.update(this.flavor) :
                             this.flavorService.create(this.flavor);

    flavorObservable.subscribe({  
        next: flavor => { 
            this.retorno.emit(flavor);
        },
        error: erro => { 
            alert('Exemplo de tratamento de erro/exception! Observe o erro no console!');
            console.error(erro);
        }
    });
  }
}
