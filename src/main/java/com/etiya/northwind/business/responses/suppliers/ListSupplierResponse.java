package com.etiya.northwind.business.responses.suppliers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListSupplierResponse {
    @NotNull
    private int supplierId;
    @NotNull
    private String companyName;
    @NotNull
    private String contactName;
    @NotNull
    private String contactTitle;
}
