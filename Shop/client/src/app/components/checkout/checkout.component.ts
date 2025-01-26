// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-checkout',
//   standalone: true,
//   imports: [],
//   templateUrl: './checkout.component.html',
//   styleUrl: './checkout.component.css'
// })
// export class CheckoutComponent {

// }
import { Component, AfterViewInit } from '@angular/core';
import { OrderModel } from '../../models/order.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-checkout',
  standalone: true,
  imports :[FormsModule],

  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent  {
model : OrderModel = {} as OrderModel
  

  submitOrder(event: Event) {
    event.preventDefault(); 

    
    const name = (document.getElementById('name') as HTMLInputElement).value;
    const email = (document.getElementById('email') as HTMLInputElement).value;
    const address = (document.getElementById('address') as HTMLInputElement).value;
    const paymentMethod = (document.getElementById('payment') as HTMLSelectElement).value;

    
    console.log('Имя:', name);
    console.log('Электронная почта:', email);
    console.log('Адрес:', address);
    console.log('Способ оплаты:', paymentMethod);

    
    alert('Заказ успешно оформлен!');
  }
}
