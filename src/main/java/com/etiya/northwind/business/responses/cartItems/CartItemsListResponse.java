package com.etiya.northwind.business.responses.cartItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemsListResponse {
    private int cartItemsId;
    private int cartId;
    private int quantity;
    private double unitPrice;
    private int productId;
    
}
