import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { Product } from '../../models/product.model';
import { ProductCardComponent } from '../product-card/product-card.component';
import { environment } from '../../../environment/environment';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [ProductCardComponent, HttpClientModule],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css',
})
export class ProductListComponent {
  data: Product[] = [];

  constructor(httpClient: HttpClient) {
    httpClient
      .get<Product[]>(environment.apiUrl + 'product/get-all-product')
      .subscribe((data) => {
        this.data = data;
      });
  }
}
