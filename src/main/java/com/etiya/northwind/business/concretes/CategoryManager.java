package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categoryRequests.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categoryRequests.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categoryRequests.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.ListCategoryResponse;
import com.etiya.northwind.business.responses.categories.ReadCategoryResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.Results.DataResult;
import com.etiya.northwind.core.utilities.Results.Result;
import com.etiya.northwind.core.utilities.Results.SuccessDataResult;
import com.etiya.northwind.core.utilities.Results.SuccessResult;
import com.etiya.northwind.core.utilities.exceptions.BusinessException;
import com.etiya.northwind.dataAccess.abstracts.CategoryRepository;
import com.etiya.northwind.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryManager implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public Result add(CreateCategoryRequest createCategoryRequest) {
        checkIfCategoryNameExists(createCategoryRequest.getCategoryName());
        checkIfCategoryExistsById(createCategoryRequest.getCategoryId());
        Category category = this.modelMapperService.forRequest().map(createCategoryRequest, Category.class);
        this.categoryRepository.save(category);
        return new SuccessResult("Added successfully");
    }


    @Override
    public Result update(UpdateCategoryRequest updateCategoryRequest) {
        Category category = this.modelMapperService.forRequest().map(updateCategoryRequest, Category.class);
        this.categoryRepository.save(category);
        return new SuccessResult("Updated successfully");
    }

    @Override
    public Result delete(DeleteCategoryRequest deleteCategoryRequest) {
        Category category = this.modelMapperService.forRequest().map(deleteCategoryRequest, Category.class);
        this.categoryRepository.deleteById(category.getCategoryId());
        return new SuccessResult("Deleted successfully");
    }

    @Override
    public DataResult<List<ListCategoryResponse>> getAll() {
        List<Category> result = this.categoryRepository.findAll();
        List<ListCategoryResponse> response =
                result.stream().map(category -> this.modelMapperService.forResponse().map(category, ListCategoryResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<ListCategoryResponse>>(response,"Listed Successfully");
    }

    @Override
    public DataResult<ReadCategoryResponse> getById(int categoryId) {
        Category category= this.categoryRepository.findById(categoryId).get();
        ReadCategoryResponse response = modelMapperService.forResponse().map(category, ReadCategoryResponse.class);
        return new SuccessDataResult<ReadCategoryResponse>(response,"Listed Successfully");
    }

    @Override
    public DataResult<List<ListCategoryResponse>> getAll(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        List<Category> categories = this.categoryRepository.findAll(pageable).getContent();
        List<ListCategoryResponse> responces = categories.stream()
                .map(item -> modelMapperService.forResponse().map(item, ListCategoryResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListCategoryResponse>>(responces,"Listed Successfully");
    }

    @Override
    public DataResult<List<ListCategoryResponse>> getAll(Integer pageNo, Integer pageSize, String field) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,Sort.by(field));
        List<Category> categories = this.categoryRepository.findAll(pageable).getContent();
        List<ListCategoryResponse> responces = categories.stream()
                .map(item -> modelMapperService.forResponse().map(item, ListCategoryResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListCategoryResponse>>(responces,"Listed Successfully");
    }

    @Override
    public DataResult<List<ListCategoryResponse>> getAll(Integer pageNo, Integer pageSize, String field, boolean isStateDescending) {
        Pageable pageable = checkAscendingOrDescending(pageNo,pageSize,field,isStateDescending);
        List<Category> categories = this.categoryRepository.findAll(pageable).getContent();
        List<ListCategoryResponse> responces = categories.stream()
                .map(item -> modelMapperService.forResponse().map(item, ListCategoryResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListCategoryResponse>>(responces,"Listed Successfully");
    }

    private void checkIfCategoryExistsById(int id)
    {
        boolean result = categoryRepository.existsById(id);
        if (result==true) {
            throw new BusinessException("CATEGORY EXISTS");
        }
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
    private void checkIfCategoryNameExists(String name) {
        Category category = this.categoryRepository.findByCategoryName(name);
        if (category != null) {
            throw new BusinessException("CHECK CATEGORY NAME!");
        }
    }
}
