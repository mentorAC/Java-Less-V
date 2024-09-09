import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Product } from './models/product.model';
import { ProductCardComponent } from "./components/product-card/product-card.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HttpClientModule, ProductCardComponent],
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
  
  data:Product[] = [];

  constructor(httpClient: HttpClient) {
    httpClient
      .get <Product[]>('http://localhost:8080/product/get-all-product')
      .subscribe((data) => {
        this.data = data;
      });

      
  }

  // handler(data: any) {
  //   console.log(data);
    
  // }
}
