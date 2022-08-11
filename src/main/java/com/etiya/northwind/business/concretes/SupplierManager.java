package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.requests.supplierRequests.CreateSupplierRequest;
import com.etiya.northwind.business.requests.supplierRequests.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.supplierRequests.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.products.ListProductResponse;
import com.etiya.northwind.business.responses.products.ReadProductResponse;
import com.etiya.northwind.business.responses.suppliers.ListSupplierResponse;
import com.etiya.northwind.business.responses.suppliers.ReadSupplierResponse;
import com.etiya.northwind.core.mapping.ModelMapperService;
import com.etiya.northwind.core.mapping.Results.DataResult;
import com.etiya.northwind.core.mapping.Results.Result;
import com.etiya.northwind.core.mapping.Results.SuccessDataResult;
import com.etiya.northwind.core.mapping.Results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.SupplierRepository;
import com.etiya.northwind.entities.concretes.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierManager implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public Result add(CreateSupplierRequest createSupplierRequest) {
        Supplier supplier = this.modelMapperService.forRequest().map(createSupplierRequest, Supplier.class);
        supplierRepository.save(supplier);
        return new SuccessResult("Added successfully");

    }

    @Override
    public Result update(UpdateSupplierRequest updateSupplierRequest) {
        Supplier supplier = this.modelMapperService.forRequest().map(updateSupplierRequest, Supplier.class);
        supplierRepository.save(supplier);
        return new SuccessResult("Updated successfully");
    }

    @Override
    public Result delete(DeleteSupplierRequest deleteSupplierRequest) {
        Supplier supplier = this.modelMapperService.forRequest().map(deleteSupplierRequest, Supplier.class);
        this.supplierRepository.deleteById(supplier.getSupplierId());
        return new SuccessResult("Deleted successfully");
    }

    @Override
    public DataResult<List<ListSupplierResponse>> getAll() {
        List<Supplier> result = this.supplierRepository.findAll();
        List<ListSupplierResponse> response =
                result.stream().map(item -> this.modelMapperService.forResponse().map(item, ListSupplierResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<ListSupplierResponse>>(response,"Listed Successfully");
    }

    @Override
    public DataResult<ReadSupplierResponse> getById( int supplierId) {
        Supplier supplier=this.supplierRepository.findById(supplierId).get();
        ReadSupplierResponse response=modelMapperService.forResponse().map(supplier, ReadSupplierResponse.class);
        return new SuccessDataResult<ReadSupplierResponse>(response,"Listed Successfully");
    }

    @Override
    public DataResult<List<ListSupplierResponse>> getAll(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        List<Supplier> suppliers = this.supplierRepository.findAll(pageable).getContent();
        List<ListSupplierResponse> responces = suppliers.stream()
                .map(item -> modelMapperService.forResponse().map(item, ListSupplierResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListSupplierResponse>>(responces,"Listed Successfully");
    }

    @Override
    public DataResult<List<ListSupplierResponse>> getAll(Integer pageNo, Integer pageSize, String field) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,Sort.by(field));
        List<Supplier> suppliers = this.supplierRepository.findAll(pageable).getContent();
        List<ListSupplierResponse> responces = suppliers.stream()
                .map(item -> modelMapperService.forResponse().map(item, ListSupplierResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListSupplierResponse>>(responces,"Listed Successfully");
    }

    @Override
    public DataResult<List<ListSupplierResponse>> getAll(Integer pageNo, Integer pageSize, String field, boolean isStateDescending) {
        Pageable pageable = checkAscendingOrDescending(pageNo,pageSize,field,isStateDescending);
        List<Supplier> suppliers = this.supplierRepository.findAll(pageable).getContent();
        List<ListSupplierResponse> responces = suppliers.stream()
                .map(item -> modelMapperService.forResponse().map(item, ListSupplierResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListSupplierResponse>>(responces,"Listed Successfully");
    }
    private Pageable checkAscendingOrDescending(Integer pageNo, Integer pageSize, String field, boolean isStateDescending)
    {
        Pageable pageable;
        if(isStateDescending)
        {
            pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(field).descending());
        }
        else
        {
            pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(field).ascending());
        }
        return pageable;
    }
}

