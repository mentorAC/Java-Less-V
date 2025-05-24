import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../models/product.model';
import { environment } from '../../environment/environment';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private http: HttpClient) {}

  getProductById(id: number) {
    return this.http.get(environment.apiUrl + `product/get-by-id/${id}`);
  }
  createProduct(product: Product) {
    return this.http.post<Product>(environment.apiUrl + `product/add`, product);
  }
  getAllProduct() {
    return this.http.get<Product[]>(
      environment.apiUrl + 'product/get-all-product'
    );
  }
  deleteProduct(id: number) {
    return this.http.delete(environment.apiUrl + `product/delete/${id}`);
  }
  editProduct(id: number, product: Product) {
    return this.http.put(environment.apiUrl + `product/update/${id}`, product);
  }
}
