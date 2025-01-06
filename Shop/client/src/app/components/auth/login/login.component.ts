import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { LoginModel } from '../../../models/login.model';
import { environment } from '../../../../environment/environment';
import { FormsModule } from '@angular/forms';
import { AccountService } from '../../../services/account.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterLink, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  model: LoginModel = {} as LoginModel;
  constructor(
    private toastr: ToastrService,
    private router: Router,
    private accountService: AccountService
  ) {}

  login() {
    // console.log(this.model);
   this.accountService.login(this.model)
      .subscribe({
        next: (result) => {
          this.toastr.success('Success');
          this.router.navigateByUrl("products");
        },
        error: (error) => {
          this.toastr.error(error);
        },
      });
  }
}
