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
  private readonly baseUrl = environment.apiUrl + "cart/";
  private cartCount = new BehaviorSubject<number>(0)
  currentCartCount$ = this.cartCount.asObservable();
  constructor(
    private readonly httpClient: HttpClient,
    private readonly accountService: AccountService
  ) {}
  incCartCount(){
    this.cartCount.next(this.cartCount.value +1)
  }
  decCartCount(){
    this.cartCount.next(this.cartCount.value -1)
  }
  setCartCount(value: number){
    this.cartCount.next(value);

  }

  add(productId: number | string) {
    return this.httpClient.post<string>(
      this.baseUrl + 'add-to-cart/' + productId,
      null,
      { headers: this.getAuthHeader() }
    );
  }
  incproduct(productId: number | string ){
    return this.httpClient.put(
      this.baseUrl+'inc-item/' + productId,
      null,
      { headers: this.getAuthHeader() }
    );
  }
  decproduct(productId:  number | string ){
    return this.httpClient.put(
      this.baseUrl+'dec-item/' + productId,
      null,
      { headers: this.getAuthHeader()
      
       }
      );
  }
  delete(productId: number | string){
    return this.httpClient.delete(
      this.baseUrl +'delete-item/'+ productId,
      { headers: this.getAuthHeader() }
    );
  }

  get(){
    return this.httpClient.get<CartItemModel[]>( this.baseUrl+"get-item",   { headers: this.getAuthHeader() });
  }

  private getAuthHeader(){
    let token = '';
    this.accountService.currentUser$.subscribe((user) => (token = user!.token));

    return new HttpHeaders().append(
      'Authorization',
      'Bearer ' + token
    );
  }
}
