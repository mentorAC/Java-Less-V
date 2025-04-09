import { Component } from '@angular/core';
import { Product } from '../../../models/product.model';
import { FormsModule } from '@angular/forms';
import { ProductService } from '../../../services/product.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-product-management',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './product-management.component.html',
  styleUrl: './product-management.component.css',
})
export class ProductManagementComponent {
  model: Product = {} as Product;
  CreateProduct() {
    this.productservice.createProduct(this.model).subscribe((product) => {
      this.model = {} as Product;
      this.toastr.success('Успіх');
    });
  }
  constructor(
    private productservice: ProductService,
    private toastr: ToastrService
  ) {}
}
