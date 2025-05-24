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
  IsEdit: boolean = false;
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
  editProduct(id: number) {
    this.model = this.data.find((p) => p.id == id)!;
    this.IsEdit = true;
  }
  updateProduct() {
    this.productservice
      .editProduct(this.model.id, this.model)
      .subscribe((data) => {
        this.toastr.success('Success Edit');
        this.IsEdit = false;
        this.model = {} as Product;
      });
  }
  editCancel() {
    this.model = {} as Product;
    this.IsEdit = false;
    this.productservice.getAllProduct().subscribe((data) => {
      this.data = data;
    });
  }
}
