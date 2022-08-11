package com.etiya.northwind.business.requests.orderDetailRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDetailRequest {


    @NotNull
    private int productId;

    @NotNull
    private int orderId;

    @NotNull
    private double unitPrice;

    @NotNull
    private int quantity;

    @NotNull
    private double discount;
}
