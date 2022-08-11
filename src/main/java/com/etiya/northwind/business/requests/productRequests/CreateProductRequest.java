package com.etiya.northwind.business.requests.productRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

    @NotNull
    private int productId;
    @NotNull
    private String productName;
    @NotNull
    private double unitPrice;
    @NotNull
    private int unitsInStock;
    @NotNull
    private int categoryId;
    @NotNull
    private int discontinued;
}
