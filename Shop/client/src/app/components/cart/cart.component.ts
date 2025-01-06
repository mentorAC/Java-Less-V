import { Component } from '@angular/core';
import { CartService } from '../../services/cart.service';
import { CartItemModel } from '../../models/cart-item.model';
import { CartItemComponent } from "./cart-item/cart-item.component";
import { CommonModule } from '@angular/common';
import { CheckoutComponent } from '../checkout/checkout.component';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [CartItemComponent,CommonModule,CheckoutComponent],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.css',
})
export class CartComponent {
  cart: CartItemModel[]=[]
  constructor(private cartService: CartService) {
    cartService.get().subscribe((res) => {
      this.cart=res
    });
  }
  deleteItem(productId: number){
    this.cart = this.cart.filter(el=>el.productId!=productId)
    this.cartService.decCartCount();
  }
}
