package com.etiya.northwind.business.responses.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadProductResponse {

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
