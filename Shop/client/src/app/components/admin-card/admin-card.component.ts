import { Component } from '@angular/core';
import { NgbNavModule } from '@ng-bootstrap/ng-bootstrap';
import { ProductManagementComponent } from './product-management/product-management.component';
import { OrderManagementComponent } from './order-management/order-management.component';

@Component({
  selector: 'app-admin-card',
  standalone: true,
  imports: [NgbNavModule, ProductManagementComponent, OrderManagementComponent],
  templateUrl: './admin-card.component.html',
  styleUrl: './admin-card.component.css',
})
export class AdminCardComponent {}
