import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environment/environment';
import { LoginModel } from '../models/login.model';
import { RegisterModel } from '../models/register.model';
import { BehaviorSubject, map } from 'rxjs';
import { UserModel } from '../models/user.model';

@Injectable({
  providedIn: 'root',
})
export class AccountService {
  private userInfoSource = new BehaviorSubject<UserModel|null>(null)
  constructor(private readonly httpClient: HttpClient) {}
  currentUser$ = this.userInfoSource.asObservable();
  login(model: LoginModel) {
    return this.httpClient.post<UserModel>(environment.apiUrl + 'account/login', model).pipe(map(user=>{
      this.setCurrentUser(user);
    }));
  }
  registration(model:RegisterModel){
    return this.httpClient.post(environment.apiUrl + 'account/register', model);
  }
  setCurrentUser(user:UserModel){
    localStorage.setItem("user", JSON.stringify(user));
    this.userInfoSource.next(user);
  }
  logout(){
    localStorage.removeItem("user");
    this.userInfoSource.next(null)
  }
}
