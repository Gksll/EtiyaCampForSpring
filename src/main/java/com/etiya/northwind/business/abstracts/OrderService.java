package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.orderRequests.CreateOrderRequest;
import com.etiya.northwind.business.requests.orderRequests.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orderRequests.UpdateOrderRequest;
import com.etiya.northwind.business.responses.orders.ListOrderResponse;
import com.etiya.northwind.business.responses.orders.ReadOrderResponse;
import com.etiya.northwind.core.utilities.Results.DataResult;
import com.etiya.northwind.core.utilities.Results.Result;

import java.util.List;

public interface OrderService {
    Result add(CreateOrderRequest createOrderRequest);
    Result update(UpdateOrderRequest updateOrderRequest);

    Result delete(DeleteOrderRequest deleteOrderRequest);
    DataResult<List<ListOrderResponse>> getAll();

    DataResult<ReadOrderResponse>  getById(int orderId);
    DataResult<List<ListOrderResponse>>  getAll(Integer pageNo, Integer pageSize);
    DataResult<List<ListOrderResponse>>  getAll(Integer pageNo, Integer pageSize,String field);
    DataResult<List<ListOrderResponse>>  getAll(Integer pageNo, Integer pageSize,String field,boolean state);
   }
