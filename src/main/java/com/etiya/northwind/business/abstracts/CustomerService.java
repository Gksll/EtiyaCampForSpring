package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.customerRequests.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customerRequests.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customerRequests.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.categories.ListCategoryResponse;
import com.etiya.northwind.business.responses.categories.ReadCategoryResponse;
import com.etiya.northwind.business.responses.customers.ListCustomerResponse;
import com.etiya.northwind.business.responses.customers.ReadCustomerResponse;
import com.etiya.northwind.core.mapping.Results.DataResult;
import com.etiya.northwind.core.mapping.Results.Result;
import com.etiya.northwind.entities.concretes.Customer;


import java.util.List;

public interface CustomerService {
    Result add(CreateCustomerRequest createCustomerRequest);
    Result update(UpdateCustomerRequest updateCustomerRequest);
    Result delete(DeleteCustomerRequest deleteCustomerRequest);
    DataResult<List<ListCustomerResponse>> getAll();
    DataResult<ReadCustomerResponse> getById(String customerId);
    DataResult<List<ListCustomerResponse>> getAll(Integer pageNo, Integer pageSize);
    DataResult<List<ListCustomerResponse>> getAll(Integer pageNo, Integer pageSize,String field);
    DataResult<List<ListCustomerResponse>> getAll(Integer pageNo, Integer pageSize,String field,boolean state);

}
