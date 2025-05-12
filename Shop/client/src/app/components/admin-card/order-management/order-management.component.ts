import { Component } from '@angular/core';
import { OrderModel } from '../../../models/order.model';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { OrderService } from '../../../services/order.service';

@Component({
  selector: 'app-order-management',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './order-management.component.html',
  styleUrl: './order-management.component.css',
})
export class OrderManagementComponent {
  data: OrderModel[] = [];
  GetOrder() {
    this.orderservice.getAllOrder().subscribe((orders) => {
      this.data = orders;
    });
  }
  constructor(private orderservice: OrderService) {
    this.GetOrder();
  }
}
