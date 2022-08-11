package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.requests.supplierRequests.CreateSupplierRequest;
import com.etiya.northwind.business.requests.supplierRequests.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.supplierRequests.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.suppliers.ListSupplierResponse;
import com.etiya.northwind.business.responses.suppliers.ReadSupplierResponse;
import com.etiya.northwind.core.mapping.Results.DataResult;
import com.etiya.northwind.core.mapping.Results.Result;
import com.etiya.northwind.entities.concretes.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {
    @Autowired
    private SupplierService supplierService;
    public SuppliersController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }



    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateSupplierRequest createSupplierRequest){
        return  this.supplierService.add(createSupplierRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody @Valid UpdateSupplierRequest updateSupplierRequest){
        return this.supplierService.update(updateSupplierRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@Valid DeleteSupplierRequest deleteSupplierRequest){
        return this.supplierService.delete(deleteSupplierRequest);
    }
    @GetMapping("/getall")
    public DataResult<List<ListSupplierResponse>> getAll(){
        return this.supplierService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<ReadSupplierResponse> getById(int  supplierId){
        return this.supplierService.getById(supplierId);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<ListSupplierResponse>> GetAll(@RequestParam int pageNo, int pageSize) {
        return supplierService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllByPageWithField")
    public DataResult<List<ListSupplierResponse>> GetAll(@RequestParam int pageNo, int pageSize,String field) {
        return supplierService.getAll(pageNo, pageSize,field);
    }
    @GetMapping("/getAllByPageWithFieldAscOrDesc")
    public DataResult<List<ListSupplierResponse>> GetAll(@RequestParam int pageNo, int pageSize,String field,boolean state) {
        return supplierService.getAll(pageNo, pageSize,field,state);
    }
}
