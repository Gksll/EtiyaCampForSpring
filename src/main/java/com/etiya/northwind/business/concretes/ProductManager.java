package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.productRequests.CreateProductRequest;
import com.etiya.northwind.business.requests.productRequests.DeleteProductRequest;
import com.etiya.northwind.business.requests.productRequests.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ListProductResponse;
import com.etiya.northwind.business.responses.products.ReadProductResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.Results.DataResult;
import com.etiya.northwind.core.utilities.Results.Result;
import com.etiya.northwind.core.utilities.Results.SuccessDataResult;
import com.etiya.northwind.core.utilities.Results.SuccessResult;
import com.etiya.northwind.core.utilities.exceptions.BusinessException;
import com.etiya.northwind.dataAccess.abstracts.ProductRepository;
import com.etiya.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductManager implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapperService modelMapperService;


    @Override
    public Result add(CreateProductRequest createProductRequest) {
        checkIfProductExistsByName(createProductRequest.getProductName());
        Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class);
        productRepository.save(product);
        return new SuccessResult("Added successfully");
    }

    @Override
    public Result update(UpdateProductRequest updateProductRequest) {
        Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
        productRepository.save(product);
        return new SuccessResult("Updated successfully");
    }

    @Override
    public Result delete(DeleteProductRequest deleteProductRequest) {
        Product product = this.modelMapperService.forRequest().map(deleteProductRequest, Product.class);
        this.productRepository.deleteById(product.getProductId());
        return new SuccessResult("Deleted successfully");
    }

    @Override
    public DataResult<List<ListProductResponse>> getAll() {
        List<Product> result = this.productRepository.findAll();
        List<ListProductResponse> response = result.stream()
                .map(product -> this.modelMapperService.forResponse()
                        .map(product, ListProductResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListProductResponse>>(response,"Listed Successfully");
    }

    @Override
    public DataResult<ReadProductResponse> getById(int productId) {
        Product product = this.productRepository.findById(productId).get();
        ReadProductResponse response = this.modelMapperService.forResponse().map(product, ReadProductResponse.class);
        return new SuccessDataResult<ReadProductResponse>(response,"Listed Successfully");
    }

    @Override
    public DataResult<List<ListProductResponse>>  getAll(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        List<Product> products = this.productRepository.findAll(pageable).getContent();
        List<ListProductResponse> responces = products.stream()
                .map(item -> modelMapperService.forResponse().map(item, ListProductResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListProductResponse>>(responces,"Listed Successfully");
    }

    @Override
    public DataResult<List<ListProductResponse>>  getAll(Integer pageNo, Integer pageSize, String field) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(field));
        List<Product> products = this.productRepository.findAll(pageable).getContent();
        List<ListProductResponse> responces = products.stream()
                .map(item -> modelMapperService.forResponse().map(item, ListProductResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListProductResponse>>(responces,"Listed Successfully");
    }

    @Override
    public DataResult<List<ListProductResponse>>  getAll(Integer pageNo, Integer pageSize, String field, boolean isStateDescending) {
        Pageable pageable = checkAscendingOrDescending(pageNo, pageSize, field, isStateDescending);
        List<Product> products = this.productRepository.findAll(pageable).getContent();
        List<ListProductResponse> responces = products.stream()
                .map(item -> modelMapperService.forResponse().map(item, ListProductResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListProductResponse>>(responces,"Listed Successfully");
    }

    private Pageable checkAscendingOrDescending(Integer pageNo, Integer pageSize, String field, boolean isStateDescending) {
        Pageable pageable;
        if (isStateDescending) {
            pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(field).descending());
        } else {
            pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(field).ascending());
        }
        return pageable;
    }
    private void checkIfProductExistsByName(String name)
    {
        Product currentProduct = productRepository.findByProductName(name);
        if (currentProduct!=null) {
            throw new BusinessException("PRODUCT EXISTS");
        }
    }
}
