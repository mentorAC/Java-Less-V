import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OrderModel } from '../models/order.model';
import { environment } from '../../environment/environment';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  constructor(private httpClient: HttpClient) {}

  public createOrder(order: OrderModel) {
    return this.httpClient.post<OrderModel>(
      environment.apiUrl + 'order/add',
      order
    );
  }
  public getAllOrder() {
    return this.httpClient.get<OrderModel[]>(
      environment.apiUrl + 'order/get-all-orders'
    );
  }
  public changeStatus(order_id: number, status_id: number) {
    return this.httpClient.put(
      environment.apiUrl + `order/changeStatus/${order_id}/${status_id}`,
      null
    );
  }
}
