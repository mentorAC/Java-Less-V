import { Product } from "./product.model";

export interface CartItemModel{
    productId: number,
    product: Product,
    quantity: number
}