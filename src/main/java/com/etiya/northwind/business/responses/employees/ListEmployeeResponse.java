package com.etiya.northwind.business.responses.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListEmployeeResponse {

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
