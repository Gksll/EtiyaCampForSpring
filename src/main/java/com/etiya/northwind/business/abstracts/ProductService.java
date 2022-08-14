package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.productRequests.CreateProductRequest;
import com.etiya.northwind.business.requests.productRequests.DeleteProductRequest;
import com.etiya.northwind.business.requests.productRequests.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ListProductResponse;
import com.etiya.northwind.business.responses.products.ReadProductResponse;
import com.etiya.northwind.core.utilities.Results.DataResult;
import com.etiya.northwind.core.utilities.Results.Result;

import java.util.List;

public interface ProductService {
    Result add(CreateProductRequest createProductRequest);
    Result update(UpdateProductRequest updateProductRequest);
    Result delete(DeleteProductRequest deleteProductRequest);
    DataResult<List<ListProductResponse>> getAll();
    DataResult<ReadProductResponse>  getById(int productId);

    DataResult<List<ListProductResponse>> getAll(Integer pageNo, Integer pageSize);
    DataResult<List<ListProductResponse>> getAll(Integer pageNo, Integer pageSize,String field);
    DataResult<List<ListProductResponse>> getAll(Integer pageNo, Integer pageSize,String field,boolean state);
}
