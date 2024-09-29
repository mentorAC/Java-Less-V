import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ProductCardComponent } from './components/product-card/product-card.component';
import { NavbarComponent } from './components/navbar/navbar.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ProductCardComponent, NavbarComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
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
