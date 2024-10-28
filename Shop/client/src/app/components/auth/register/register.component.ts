import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
})
export class RegisterComponent {
  username: string = '';
  phone: string = '';
  password: string = '';
  repeatpassword: string = '';
  email: string = '';
  constructor(private toastr: ToastrService) {}
  register() {
    this.toastr.success("Success", "Good job!", {
      toastClass: ' pink-toastr '
    })
  }
}
