import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { AccountService } from '../services/account.service';

export const jwtInterceptor: HttpInterceptorFn = (req, next) => {
  const accountService = inject(AccountService)
  let token = null
  accountService.currentUser$.subscribe((user) => (token = user?.token));
  if(token){
    req = req.clone({
  
      setHeaders: {
        Authorization: "Bearer " + token
      }
    })
  
  }
  return next(req);
  
};
