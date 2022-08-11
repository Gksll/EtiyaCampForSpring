package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.supplierRequests.CreateSupplierRequest;
import com.etiya.northwind.business.requests.supplierRequests.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.supplierRequests.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.products.ListProductResponse;
import com.etiya.northwind.business.responses.products.ReadProductResponse;
import com.etiya.northwind.business.responses.suppliers.ListSupplierResponse;
import com.etiya.northwind.business.responses.suppliers.ReadSupplierResponse;
import com.etiya.northwind.core.mapping.Results.DataResult;
import com.etiya.northwind.core.mapping.Results.Result;
import com.etiya.northwind.entities.concretes.Supplier;

import java.util.List;

public interface SupplierService {
    Result add(CreateSupplierRequest createSupplierRequest);
    Result update(UpdateSupplierRequest updateSupplierRequest);
    Result delete(DeleteSupplierRequest deleteSupplierRequest);
    DataResult<List<ListSupplierResponse>> getAll();
    DataResult<ReadSupplierResponse>  getById(int supplierId);
    DataResult<List<ListSupplierResponse>> getAll(Integer pageNo, Integer pageSize);
    DataResult<List<ListSupplierResponse>>getAll(Integer pageNo, Integer pageSize,String field);
    DataResult<List<ListSupplierResponse>> getAll(Integer pageNo, Integer pageSize,String field,boolean state);
}
