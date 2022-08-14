package com.etiya.northwind.business.requests.cartInvoices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCartInvoiceRequest {
    private int cartInvoiceId;
}
