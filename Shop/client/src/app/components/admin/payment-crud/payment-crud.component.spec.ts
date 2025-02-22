import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentCrudComponent } from './payment-crud.component';

describe('PaymentCrudComponent', () => {
  let component: PaymentCrudComponent;
  let fixture: ComponentFixture<PaymentCrudComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PaymentCrudComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaymentCrudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
