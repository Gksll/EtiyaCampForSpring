package com.etiya.northwind.business.requests.orderRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {

    @NotNull
    private int orderId;
    @NotNull
    private String customerId;
    @NotNull
    private int employeeId;
    @NotNull
    private LocalDate orderDate;
}
