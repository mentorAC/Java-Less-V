import {
  Directive,
  inject,
  Input,
  OnInit,
  TemplateRef,
  ViewContainerRef,
} from '@angular/core';
import { AccountService } from '../services/account.service';
import { UserModel } from '../models/user.model';

@Directive({
  selector: '[appHasRole]',
  standalone: true,
})
export class HasRoleDirective implements OnInit {
  @Input() appHasRole: string[] = [];
  user: UserModel | null = {} as UserModel;
  constructor(
    private accountService: AccountService,
    private viewContainer: ViewContainerRef,
    private templateRef: TemplateRef<any>
  ) {
    this.accountService.currentUser$.subscribe((user) => {
      console.log(user);
      this.user = user;
      this.ngOnInit();
    });
  }
  ngOnInit(): void {
    if (this.user?.roles?.some((r) => this.appHasRole.includes(r))) {
      this.viewContainer.createEmbeddedView(this.templateRef);
    } else {
      this.viewContainer.clear();
    }
  }
}
