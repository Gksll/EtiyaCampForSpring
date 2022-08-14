package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.employeeRequests.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employeeRequests.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.ListEmployeeResponse;
import com.etiya.northwind.business.responses.employees.ReadEmployeeResponse;
import com.etiya.northwind.core.utilities.Results.DataResult;
import com.etiya.northwind.core.utilities.Results.Result;


import java.util.List;

public interface EmployeeService {

    Result add(CreateEmployeeRequest createEmployeeRequest);
    Result update(UpdateEmployeeRequest updateEmployeeRequest);
    Result delete(DeleteEmployeeRequest deleteEmployeeRequest);
    DataResult<List<ListEmployeeResponse>> getAll();
    DataResult<ReadEmployeeResponse>  getById(int employeeId);
    DataResult<List<ListEmployeeResponse>> getAll(Integer pageNo, Integer pageSize);
    DataResult<List<ListEmployeeResponse>> getAll(Integer pageNo, Integer pageSize,String field);
    DataResult<List<ListEmployeeResponse>> getAll(Integer pageNo, Integer pageSize,String field,boolean state);


}
