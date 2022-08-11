package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categoryRequests.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categoryRequests.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categoryRequests.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.PageDataResponse;
import com.etiya.northwind.business.responses.categories.ListCategoryResponse;
import com.etiya.northwind.business.responses.categories.ReadCategoryResponse;
import com.etiya.northwind.core.mapping.Results.DataResult;
import com.etiya.northwind.core.mapping.Results.Result;
import com.etiya.northwind.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getall")
    public DataResult<List<ListCategoryResponse>> getAll(){
        return this.categoryService.getAll();
    }


    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateCategoryRequest createCategoryRequest){
      return  this.categoryService.add(createCategoryRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody @Valid UpdateCategoryRequest updateCategoryRequest){
        return  this.categoryService.update(updateCategoryRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@Valid DeleteCategoryRequest deleteCategoryRequest){
        return this.categoryService.delete(deleteCategoryRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<ReadCategoryResponse> getById( int  categoryId){
        return this.categoryService.getById(categoryId);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<ListCategoryResponse>> GetAll(@RequestParam int pageNo, int pageSize) {
        return categoryService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllByPageWithField")
    public DataResult<List<ListCategoryResponse>> GetAll(@RequestParam int pageNo, int pageSize,String field) {
        return categoryService.getAll(pageNo, pageSize,field);
    }
    @GetMapping("/getAllByPageWithFieldAscOrDesc")
    public DataResult<List<ListCategoryResponse>> GetAll(@RequestParam int pageNo, int pageSize,String field,boolean state) {
        return categoryService.getAll(pageNo, pageSize,field,state);
    }
}