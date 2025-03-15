import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OrderModel } from '../models/order.model';
import { environment } from '../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private httpClient: HttpClient) {
   }

   public createOrder(order: OrderModel){
    this.httpClient.post(environment.apiUrl+"Order/add",order)

   }
}
