package com.etiya.northwind.business.responses.cartInvoices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartInvoiceListResponse {
    private int cartInvoiceId;
    private int cartId;
    private double totalPrice;
}
