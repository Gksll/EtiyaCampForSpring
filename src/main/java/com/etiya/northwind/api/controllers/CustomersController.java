package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.requests.customerRequests.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customerRequests.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customerRequests.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.ListCustomerResponse;
import com.etiya.northwind.business.responses.customers.ReadCustomerResponse;
import com.etiya.northwind.core.utilities.Results.DataResult;
import com.etiya.northwind.core.utilities.Results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {
    private CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getall")
    public DataResult<List<ListCustomerResponse>> getAll() {
        return this.customerService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateCustomerRequest createCustomerRequest) {
        return this.customerService.add(createCustomerRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody @Valid UpdateCustomerRequest updateCustomerRequest) {
        return this.customerService.update(updateCustomerRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@Valid DeleteCustomerRequest deleteCustomerRequest){
        return this.customerService.delete(deleteCustomerRequest);
    }

    @GetMapping("/getbyid")
    public   DataResult<ReadCustomerResponse>  getById(  String customerId){
        return this.customerService.getById(customerId);
    }

    @GetMapping("/getAllByPage")
    public  DataResult<List<ListCustomerResponse>> GetAll(@RequestParam int pageNo, int pageSize) {
        return customerService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllByPageWithField")
    public  DataResult<List<ListCustomerResponse>> GetAll(@RequestParam int pageNo, int pageSize,String field) {
        return customerService.getAll(pageNo, pageSize,field);
    }
    @GetMapping("/getAllByPageWithFieldAscOrDesc")
    public  DataResult<List<ListCustomerResponse>> GetAll(@RequestParam int pageNo, int pageSize,String field,boolean state) {
        return customerService.getAll(pageNo, pageSize,field,state);
    }




}
