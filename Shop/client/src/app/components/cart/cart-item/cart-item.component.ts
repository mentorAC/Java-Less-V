import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CartService } from '../../../services/cart.service';
import { CartItemModel } from '../../../models/cart-item.model';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-cart-item',
  standalone: true,
  imports: [],
  templateUrl: './cart-item.component.html',
  styleUrl: './cart-item.component.css',
})
export class CartItemComponent {
  constructor(private cartService: CartService, private toastr:ToastrService) {}
  @Input() model: CartItemModel = {} as CartItemModel;
  @Output() deleteHandle = new EventEmitter<number>();
  incfunction() {
    this.cartService.incproduct(this.model.productId).subscribe(() => {
      this.model.quantity++;
    });
  }
  deletefunction(){
    this.cartService.delete(this.model.productId).subscribe({
      next:()=>{ 
        this.toastr.success("Success"); 
        this.deleteHandle.emit(this.model.productId)
      },
      error:()=>{ 
        this.toastr.error("Error")}
    })
  }
  decfunction() {
    if (this.model.quantity != 1) {
  

      this.cartService.decproduct(this.model.productId).subscribe(() => {
         this.model.quantity--;
      });
    }
  }
}
