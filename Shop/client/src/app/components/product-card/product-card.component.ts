import { Component, Input } from '@angular/core';
import { Product } from '../../models/product.model';
import { CartService } from '../../services/cart.service';
import { ToastrModule, ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-product-card',
  standalone: true,
  imports: [ToastrModule],
  templateUrl: './product-card.component.html',
  styleUrl: './product-card.component.css'
})
export class ProductCardComponent {
  constructor(
    private readonly cartService: CartService,
    private readonly toastr: ToastrService ){}
  @Input() item: Product = {} as Product

  addToCart(){
    this.cartService.add(this.item.id).subscribe(res =>{
      this.toastr.success(res?.length>0 ? res : "Success");
      if(!res){
    this.cartService.incCartCount();

      }
    });
    
  }
}
