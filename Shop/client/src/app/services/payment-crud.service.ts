import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class PaymentCrudService {
  private readonly baseUrl = environment.apiUrl + 'paymant_type/';
  constructor(private httpClient: HttpClient) {
   }
   
   public  create(name: string) {
    return this.httpClient.post(this.baseUrl,{name})
    
   }
}
