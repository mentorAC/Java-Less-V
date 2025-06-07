import { Type } from '@angular/core';
import { PaymentTypeModel } from './paymentType.models';
import { StatusModel } from './status.model';

export interface OrderModel {
  id: number;
  totalAmount: number;
  statusId: number;
  deliveryAddress: string;
  email: string;
  paymentTypeId: number;
  phone: string;
  type: PaymentTypeModel;
  status: StatusModel;
}
