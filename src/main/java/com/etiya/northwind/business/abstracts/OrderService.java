package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.orderRequests.CreateOrderRequest;
import com.etiya.northwind.business.requests.orderRequests.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orderRequests.UpdateOrderRequest;
import com.etiya.northwind.business.responses.PageDataResponse;
import com.etiya.northwind.business.responses.categories.ListCategoryResponse;
import com.etiya.northwind.business.responses.orderDetails.ListOrderDetailResponse;
import com.etiya.northwind.business.responses.orderDetails.ReadOrderDetailResponse;
import com.etiya.northwind.business.responses.orders.ListOrderResponse;
import com.etiya.northwind.business.responses.orders.ReadOrderResponse;
import com.etiya.northwind.core.mapping.Results.DataResult;
import com.etiya.northwind.core.mapping.Results.Result;
import com.etiya.northwind.entities.concretes.Order;

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
