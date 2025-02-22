import { Component } from '@angular/core';
import { PaymentCrudService } from '../../../services/payment-crud.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-payment-crud',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './payment-crud.component.html',
  styleUrl: './payment-crud.component.css'
})
export class PaymentCrudComponent {
  name: string = "";
   buttonClick() {
    this.paymentservice.create(this.name).subscribe();

    
  }
  constructor(private paymentservice: PaymentCrudService){}

}
