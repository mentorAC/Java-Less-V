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
import { OrderService } from '../../services/order.service';

@Component({
  selector: 'app-checkout',
  standalone: true,
  imports :[FormsModule],

  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent  {
model : OrderModel = {} as OrderModel
  constructor(private orderService : OrderService){}

  submitOrder() {
    this.orderService.createOrder(this.model)

  }
}
