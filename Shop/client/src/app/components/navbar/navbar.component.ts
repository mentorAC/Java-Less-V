import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { AccountService } from '../../services/account.service';
import { CommonModule } from '@angular/common';
import { CartService } from '../../services/cart.service';
import { HasRoleDirective } from '../../directives/has-role.directive';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterLink, CommonModule, HasRoleDirective],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent implements OnInit {
  constructor(
    public readonly accoutnService: AccountService,
    private readonly router: Router,
    public readonly cartService: CartService
  ) {}

  ngOnInit(): void {
    this.cartService.get().subscribe((res) => {
      this.cartService.setCartCount(res.length);
    });
  }
  logout() {
    this.accoutnService.logout();
    this.router.navigateByUrl('login');
  }
}
