import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { environment } from '../../../../environment/environment';
import { RegisterModel } from '../../../models/register.model';
import { AccountService } from '../../../services/account.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
})
export class RegisterComponent {
  model: RegisterModel = {} as RegisterModel;
  repeatpassword: string = '';
  constructor(
    private toastr: ToastrService,
    private accountService:AccountService) {}
  register() {
    if (this.model.password !== this.repeatpassword) {
      this.toastr.warning('Passwords don`t equales');
      return;
    }

   this.accountService.registration(this.model).subscribe({
      next: _ =>{
          this.toastr.success('Success!');
          this.model = {} as RegisterModel;
      },
      error: error=>{
        this.toastr.error(error);
      }
    });

    // this.toastr.success("Success", "Good job!", {
    //   toastClass: ' pink-toastr '
    // })
  }
}
