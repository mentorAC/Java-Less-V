import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ProductCardComponent } from './components/product-card/product-card.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CartItemComponent } from "./components/cart/cart-item/cart-item.component";
import { AccountService } from './services/account.service';
import { jwtDecode } from 'jwt-decode';
import { PaymentCrudComponent } from "./components/admin/payment-crud/payment-crud.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NavbarComponent, PaymentCrudComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  constructor(private readonly accountService: AccountService){
    const storageUser = localStorage.getItem("user");
    if(storageUser){
      const user = JSON.parse(storageUser);
      const decoded = jwtDecode(user.token);
      if(decoded && new Date((decoded as any).exp*1000)< new Date()){
        localStorage.removeItem("user")
        return;


      }


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
