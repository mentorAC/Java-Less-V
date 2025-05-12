import { Component } from '@angular/core';
import { Product } from '../../../models/product.model';
import { FormsModule } from '@angular/forms';
import { ProductService } from '../../../services/product.service';
import { ToastrService } from 'ngx-toastr';
import { CommonModule } from '@angular/common';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ConfirmModalComponent } from '../../modals/confirm-modal/confirm-modal.component';

@Component({
  selector: 'app-product-management',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './product-management.component.html',
  styleUrl: './product-management.component.css',
})
export class ProductManagementComponent {
  data: Product[] = [];
  model: Product = {} as Product;
  CreateProduct() {
    this.productservice.createProduct(this.model).subscribe((product) => {
      this.model = {} as Product;
      this.toastr.success('Успіх');
      this.data.push(product);
    });
  }
  constructor(
    private productservice: ProductService,
    private toastr: ToastrService,
    private modal: NgbModal
  ) {
    productservice.getAllProduct().subscribe((data) => {
      this.data = data;
    });
  }
  DeleteProduct(id: number) {
    const OpenModal = this.modal.open(ConfirmModalComponent);
    OpenModal.result.then(() => {
      this.productservice.deleteProduct(id).subscribe(() => {
        this.data = this.data.filter((x) => x.id != id);
      });
    });
  }
}
