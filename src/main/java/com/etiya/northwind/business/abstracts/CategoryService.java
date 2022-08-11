package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.categoryRequests.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categoryRequests.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categoryRequests.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.ListCategoryResponse;
import com.etiya.northwind.business.responses.categories.ReadCategoryResponse;
import com.etiya.northwind.core.mapping.Results.DataResult;
import com.etiya.northwind.core.mapping.Results.Result;
import com.etiya.northwind.entities.concretes.Category;


import java.util.List;

public interface CategoryService {

    Result add(CreateCategoryRequest createCategoryRequest);
    Result update(UpdateCategoryRequest updateCategoryRequest);
    Result delete(DeleteCategoryRequest deleteCategoryRequest);
    DataResult<List<ListCategoryResponse>>  getAll();
    DataResult<ReadCategoryResponse> getById(int categoryId);
    DataResult<List<ListCategoryResponse>> getAll(Integer pageNo, Integer pageSize);
    DataResult<List<ListCategoryResponse>> getAll(Integer pageNo, Integer pageSize,String field);
    DataResult<List<ListCategoryResponse>> getAll(Integer pageNo, Integer pageSize,String field,boolean state);



}
