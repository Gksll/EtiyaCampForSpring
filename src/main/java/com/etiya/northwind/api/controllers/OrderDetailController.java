package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.categoryRequests.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categoryRequests.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categoryRequests.UpdateCategoryRequest;
import com.etiya.northwind.business.requests.orderDetailRequests.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetailRequests.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetailRequests.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.categories.ListCategoryResponse;
import com.etiya.northwind.business.responses.categories.ReadCategoryResponse;
import com.etiya.northwind.business.responses.orderDetails.ListOrderDetailResponse;
import com.etiya.northwind.business.responses.orderDetails.ReadOrderDetailResponse;
import com.etiya.northwind.core.mapping.Results.DataResult;
import com.etiya.northwind.core.mapping.Results.Result;
import com.etiya.northwind.entities.concretes.Category;
import com.etiya.northwind.entities.concretes.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/orderDetails")
public class OrderDetailController {
    private OrderDetailService orderDetailService;

    @Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateOrderDetailRequest createOrderDetailRequest){
        return  this.orderDetailService.add(createOrderDetailRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody @Valid UpdateOrderDetailRequest updateOrderDetailRequest){
        return this.orderDetailService.update(updateOrderDetailRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@Valid DeleteOrderDetailRequest deleteOrderDetailRequest){
        return this.orderDetailService.delete(deleteOrderDetailRequest);
    }
    @GetMapping("/getall")
    public DataResult<List<ListOrderDetailResponse>> getAll(){
        return this.orderDetailService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<ReadOrderDetailResponse> getById(int orderId, int productId){
        return this.orderDetailService.getById(orderId,productId);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<ListOrderDetailResponse>> GetAll(@RequestParam int pageNo, int pageSize) {
        return orderDetailService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllByPageWithField")
    public DataResult<List<ListOrderDetailResponse>> GetAll(@RequestParam int pageNo, int pageSize,String field) {
        return orderDetailService.getAll(pageNo, pageSize,field);
    }
    @GetMapping("/getAllByPageWithFieldAscOrDesc")
    public DataResult<List<ListOrderDetailResponse>> GetAll(@RequestParam int pageNo, int pageSize,String field,boolean state) {
        return orderDetailService.getAll(pageNo, pageSize,field,state);
    }
}
