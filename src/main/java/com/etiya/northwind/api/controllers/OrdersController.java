package com.etiya.northwind.api.controllers;


import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.requests.orderRequests.CreateOrderRequest;
import com.etiya.northwind.business.requests.orderRequests.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orderRequests.UpdateOrderRequest;
import com.etiya.northwind.business.responses.orders.ListOrderResponse;
import com.etiya.northwind.business.responses.orders.ReadOrderResponse;
import com.etiya.northwind.core.utilities.Results.DataResult;
import com.etiya.northwind.core.utilities.Results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateOrderRequest createOrderRequest){
        return  this.orderService.add(createOrderRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody @Valid UpdateOrderRequest updateOrderRequest){
        return   this.orderService.update(updateOrderRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@Valid DeleteOrderRequest deleteOrderRequest){
        return   this.orderService.delete(deleteOrderRequest);
    }

    @GetMapping("/getall")
    public DataResult<List<ListOrderResponse>> getAll(){
        return this.orderService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<ReadOrderResponse> getById( int orderId){
        return this.orderService.getById(orderId);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<ListOrderResponse>> GetAll(@RequestParam int pageNo, int pageSize) {
        return orderService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllByPageWithField")
    public DataResult<List<ListOrderResponse>> GetAll(@RequestParam int pageNo, int pageSize,String field) {
        return orderService.getAll(pageNo, pageSize,field);
    }
    @GetMapping("/getAllByPageWithFieldAscOrDesc")
    public DataResult<List<ListOrderResponse>> GetAll(@RequestParam int pageNo, int pageSize,String field,boolean state) {
        return orderService.getAll(pageNo, pageSize,field,state);
    }
}
