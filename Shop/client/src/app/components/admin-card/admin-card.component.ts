import { Component } from '@angular/core';
import { NgbNavModule } from '@ng-bootstrap/ng-bootstrap';
import { ProductManagementComponent } from './product-management/product-management.component';

@Component({
  selector: 'app-admin-card',
  standalone: true,
  imports: [NgbNavModule, ProductManagementComponent],
  templateUrl: './admin-card.component.html',
  styleUrl: './admin-card.component.css',
})
export class AdminCardComponent {
  active = 1;
}
