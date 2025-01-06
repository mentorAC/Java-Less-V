import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ProductCardComponent } from './components/product-card/product-card.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CartItemComponent } from "./components/cart/cart-item/cart-item.component";
import { AccountService } from './services/account.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ProductCardComponent, NavbarComponent, CartItemComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  constructor(private readonly accountService: AccountService){
    const storageUser = localStorage.getItem("user");
    if(storageUser){
      const user = JSON.parse(storageUser);
      accountService.setCurrentUser(user);
    }
  }
  // title = 'Client!';
  // counter = 0;
  // buttonClick(){
  //   //console.log("click");
  //   this.counter++;
  // }
  // buttonMinus(){
  //   this.counter--;
  // }
  // handler(data: any) {
  //   console.log(data);
  // }
}
