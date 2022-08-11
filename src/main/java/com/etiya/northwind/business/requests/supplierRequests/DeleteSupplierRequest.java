package com.etiya.northwind.business.requests.supplierRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteSupplierRequest {

    @NotNull
    private int supplierId;

}
