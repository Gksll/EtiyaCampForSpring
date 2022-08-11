package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.categoryRequests.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.employeeRequests.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employeeRequests.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.PageDataResponse;
import com.etiya.northwind.business.responses.categories.ListCategoryResponse;
import com.etiya.northwind.business.responses.categories.ReadCategoryResponse;
import com.etiya.northwind.business.responses.employees.ListEmployeeResponse;
import com.etiya.northwind.business.responses.employees.ReadEmployeeResponse;
import com.etiya.northwind.core.mapping.Results.DataResult;
import com.etiya.northwind.core.mapping.Results.Result;
import com.etiya.northwind.entities.concretes.Category;
import com.etiya.northwind.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getall")
    public DataResult<List<ListEmployeeResponse>> getAll(){
        return this.employeeService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateEmployeeRequest createEmployeeRequest){
        return this.employeeService.add(createEmployeeRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody @Valid UpdateEmployeeRequest updateEmployeeRequest){
        return this.employeeService.update(updateEmployeeRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@Valid DeleteEmployeeRequest deleteEmployeeRequest){
        return   this.employeeService.delete(deleteEmployeeRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<ReadEmployeeResponse> getById(int  employeeId){
        return this.employeeService.getById(employeeId);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<ListEmployeeResponse>> GetAll(@RequestParam int pageNo, int pageSize) {
        return employeeService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllByPageWithField")
    public DataResult<List<ListEmployeeResponse>> GetAll(@RequestParam int pageNo, int pageSize,String field) {
        return employeeService.getAll(pageNo, pageSize,field);
    }
    @GetMapping("/getAllByPageWithFieldAscOrDesc")
    public DataResult<List<ListEmployeeResponse>> GetAll(@RequestParam int pageNo, int pageSize,String field,boolean state) {
        return employeeService.getAll(pageNo, pageSize,field,state);
    }

}
