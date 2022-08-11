package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.productRequests.CreateProductRequest;
import com.etiya.northwind.business.requests.productRequests.DeleteProductRequest;
import com.etiya.northwind.business.requests.productRequests.UpdateProductRequest;
import com.etiya.northwind.business.responses.PageDataResponse;
import com.etiya.northwind.business.responses.categories.ListCategoryResponse;
import com.etiya.northwind.business.responses.orders.ListOrderResponse;
import com.etiya.northwind.business.responses.orders.ReadOrderResponse;
import com.etiya.northwind.business.responses.products.ListProductResponse;
import com.etiya.northwind.business.responses.products.ReadProductResponse;
import com.etiya.northwind.core.mapping.Results.DataResult;
import com.etiya.northwind.core.mapping.Results.Result;
import com.etiya.northwind.entities.concretes.Product;

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
