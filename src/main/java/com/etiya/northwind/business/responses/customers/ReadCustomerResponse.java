package com.etiya.northwind.business.responses.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadCustomerResponse {

    @NotNull
    private String customerId;
//    @NotNull
    private String companyName;
//    @NotNull
    private String contactName;
//    @NotNull
    private String contactTitle;

}
