package com.etiya.northwind.business.requests.cartItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCartItemsRequest {
    private int cartId;
    private int productId;
    private int quantity;
    private double unitPrice;

}
