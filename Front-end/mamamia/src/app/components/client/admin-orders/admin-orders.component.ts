import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product/product';
import { Flavor } from 'src/app/models/flavor/flavor';
import { FlavorService } from 'src/app/services/flavor/flavor.service';

@Component({
  selector: 'app-admin-orders',
  templateUrl: './admin-orders.component.html',
  styleUrls: ['./admin-orders.component.scss']
})
export class AdminOrdersComponent implements OnInit {
  orders: any[] = [];

  flavors: Flavor[] = [];
  isValidName = true;
  selectedFlavorForEdit: Flavor = new Flavor();

  constructor(private flavorService: FlavorService) { }

  ngOnInit(): void {
    this.listAllFlavors();
  }

  listAllFlavors(): void {
    this.flavorService.getAllFlavors().subscribe(
      data => {
        this.flavors = data;
        this.flavors.sort((a, b) => b.id - a.id); 
        console.log(this.flavors);
      },
      error => {
        console.error('Error:', error);
        alert('An error occurred. Please check the console for more details.');
      }
    );
  }

  addFlavor(modal: any): void {
    this.selectedFlavorForEdit = new Flavor();
  }

  editFlavor(modal: any, flavor: Flavor, index: number): void {
    this.selectedFlavorForEdit = Object.assign({}, flavor);
  }

  saveOrUpdateFlavor(flavor: Flavor): void {
    if (!flavor.nome) {
      alert('Please insert valid data.');
      return;
    }

    const flavorObservable = flavor.id ? 
                             this.flavorService.updateFlavor(flavor) : 
                             this.flavorService.createFlavor(flavor);

    flavorObservable.subscribe(
      responseFlavor => {
        const index = this.flavors.findIndex(f => f.id === responseFlavor.id);
        if (index !== -1) {
          this.flavors[index] = responseFlavor;
          alert('Flavor updated successfully!');
        } else {
          this.flavors.unshift(responseFlavor);
          alert('Flavor added successfully!');
        }
      },
      error => {
        const action = flavor.id ? "update" : "add";
        alert(`An error occurred while trying to ${action} the flavor.`);
        console.error(error);
      }
    );

  }

  deleteFlavor(flavor: Flavor): void {
    if (!flavor.id) { 
      console.error('Flavor ID is undefined or null. Cannot delete flavor.');
      alert('Error: Cannot delete flavor without a valid ID.');
      return;
    }

    if (confirm('Are you sure you want to delete this flavor?')) {
      this.flavorService.deleteFlavor(flavor.id).subscribe(
        () => {
          const index = this.flavors.findIndex(f => f.id === flavor.id);
          if (index !== -1) {
            this.flavors.splice(index, 1);
          }
          alert('Flavor deleted successfully!');
        },
        error => {
          alert('An error occurred while trying to delete the flavor.');
          console.error(error);
        }
      );
    }
  }

  validateName(name: string): void {
    this.isValidName = !!name.trim(); 
  }
}


