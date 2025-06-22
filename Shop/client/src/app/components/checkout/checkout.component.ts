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
import { ToastrService } from 'ngx-toastr';
import { CartService } from '../../services/cart.service';

@Component({
  selector: 'app-checkout',
  standalone: true,
  imports: [FormsModule],

  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css'],
})
export class CheckoutComponent {
  model: OrderModel = {} as OrderModel;
  constructor(
    private orderService: OrderService,
    private readonly cartService: CartService,
    private readonly toastr: ToastrService
  ) {}

  submitOrder() {
    this.orderService.createOrder(this.model).subscribe((order) => {
      this.toastr.success('Order created, order number: ' + order.id);
      this.cartService.setCartCount(0);
    });
  }
}
