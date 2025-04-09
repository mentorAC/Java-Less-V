import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../models/product.model';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private http: HttpClient) {}

  getProductById(id: number) {
    return this.http.get(`http://localhost:8080/product/get-by-id/${id}`);
  }
  createProduct(product: Product) {
    return this.http.post(`http://localhost:8080/product/add`, product);
  }
}
