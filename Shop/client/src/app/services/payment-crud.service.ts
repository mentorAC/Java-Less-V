import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class PaymentCrudService {
  private readonly baseUrl = environment.apiUrl + 'payments/';
  constructor(private httpClient: HttpClient) {
   }
   
   public  create(name: string) {
    return this.httpClient.post(this.baseUrl,{name})
    
   }
   public get(){
    return this.httpClient.get<any>(this.baseUrl)

   }
}
