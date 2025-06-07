import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';

import { Product } from '../../models/product.model';
import { ProductCardComponent } from '../product-card/product-card.component';
import { environment } from '../../../environment/environment';
import { ProductService } from '../../services/product.service';
import { NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [ProductCardComponent, NgbPaginationModule],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css',
})
export class ProductListComponent {
  data: Product[] = [];
  page: number = 1;

  constructor(private productservice: ProductService) {
    productservice.getAllProduct().subscribe((data) => {
      this.data = data;
    });
  }
}
