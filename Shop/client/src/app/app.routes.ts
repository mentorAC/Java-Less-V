import { Routes } from '@angular/router';
import { ProductListComponent } from './components/product-list/product-list.component';
import { LoginComponent } from './components/auth/login/login.component';

export const routes: Routes = [
  { path: 'products', component: ProductListComponent },
  {path: 'login', component: LoginComponent}
];
