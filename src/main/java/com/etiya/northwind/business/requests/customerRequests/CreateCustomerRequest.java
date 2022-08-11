package com.etiya.northwind.business.requests.customerRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequest {

    @NotNull
    private String customerId;
    @NotNull
    private String companyName;
    @NotNull
    private String contactName;
    @NotNull
    private String contactTitle;
}
