// payment-form.component.ts
import { Component } from '@angular/core';
// import { faGooglePay, faCcMastercard, faUtensils } from '@fortawesome/free-brands-svg-icons';
// import { library } from '@fortawesome/fontawesome-svg-core';

@Component({
  selector: 'app-payment-form',
  templateUrl: './payment-form.component.html',
  styleUrls: ['./payment-form.component.scss']
})
export class PaymentFormComponent {
  paymentMethod = 'card';
  cardNumber?: string;
  cardCVV?: string;
  cardName?: string;
  randomPixNumber?: string;
  needChange?: boolean = false;
  changeAmount?: number;
  showPaymentMethods = true;
  showAddCardForm = false;
  newCardNumber = '';
  newCardCVV = '';
  newCardName = '';
  showPaymentOptions = true;

  
  constructor() {
    this.cardNumber = '';
    this.cardCVV = '';
    this.cardName = '';
    this.randomPixNumber = this.generateRandomPixNumber();
    this.changeAmount = 0;
    
  }


  addNewCard() {
    this.showPaymentOptions = false;
    this.showPaymentMethods = false;
    this.showAddCardForm = true;
  }

  submitCard() {
    this.showPaymentMethods = true;
    this.showAddCardForm = false;
  }

  cancelAddCard() {
    this.showPaymentMethods = true;
    this.showAddCardForm = false;
    this.showPaymentOptions = true;
  }

  onPaymentMethodChange() {
    this.cardNumber = '';
    this.cardCVV = '';
    this.cardName = '';
    this.changeAmount = 0;
  }

  generateRandomPixNumber(): string {
    return Math.random().toString(36).substring(2, 15);
  }
  
  submitPayment() {
  }
}
