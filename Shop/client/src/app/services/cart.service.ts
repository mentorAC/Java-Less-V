import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environment/environment';
import { AccountService } from './account.service';
import { CartItemModel } from '../models/cart-item.model';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  private readonly baseUrl = environment.apiUrl + 'cart/';
  private cartCount = new BehaviorSubject<number>(0);
  currentCartCount$ = this.cartCount.asObservable();
  constructor(
    private readonly httpClient: HttpClient,
    private readonly accountService: AccountService
  ) {}
  incCartCount() {
    this.cartCount.next(this.cartCount.value + 1);
  }
  decCartCount() {
    this.cartCount.next(this.cartCount.value - 1);
  }
  setCartCount(value: number) {
    this.cartCount.next(value);
  }

  add(productId: number | string) {
    return this.httpClient.post<string>(
      this.baseUrl + 'add-to-cart/' + productId,
      null
    );
  }
  incproduct(productId: number | string) {
    return this.httpClient.put(this.baseUrl + 'inc-item/' + productId, null);
  }
  decproduct(productId: number | string) {
    return this.httpClient.put(this.baseUrl + 'dec-item/' + productId, null);
  }
  delete(productId: number | string) {
    return this.httpClient.delete(this.baseUrl + 'delete-item/' + productId);
  }

  get() {
    return this.httpClient.get<CartItemModel[]>(this.baseUrl + 'get-item');
  }
}
