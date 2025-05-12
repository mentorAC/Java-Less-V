import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-confirm-modal',
  standalone: true,
  imports: [],
  templateUrl: './confirm-modal.component.html',
  styleUrl: './confirm-modal.component.css',
})
export class ConfirmModalComponent {
  constructor(public modal: NgbActiveModal) {}
  Save() {
    this.modal.close();
  }
  Close() {
    this.modal.dismiss();
  }
}
