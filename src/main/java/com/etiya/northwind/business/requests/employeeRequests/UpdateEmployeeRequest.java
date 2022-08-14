package com.etiya.northwind.business.requests.employeeRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeRequest {

    @NotNull
    private int employeeId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String title;
    @NotNull
    private Integer reportsTo;
}
