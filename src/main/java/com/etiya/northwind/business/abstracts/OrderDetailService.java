package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.orderDetailRequests.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetailRequests.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetailRequests.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.employees.ListEmployeeResponse;
import com.etiya.northwind.business.responses.employees.ReadEmployeeResponse;
import com.etiya.northwind.business.responses.orderDetails.ListOrderDetailResponse;
import com.etiya.northwind.business.responses.orderDetails.ReadOrderDetailResponse;
import com.etiya.northwind.core.mapping.Results.DataResult;
import com.etiya.northwind.core.mapping.Results.Result;
import com.etiya.northwind.entities.concretes.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    Result add(CreateOrderDetailRequest createOrderDetailRequest);
    Result update(UpdateOrderDetailRequest updateOrderDetailRequest);
    Result delete(DeleteOrderDetailRequest deleteOrderDetailRequest);
    DataResult<List<ListOrderDetailResponse>> getAll();
    DataResult<ReadOrderDetailResponse>  getById(int orderId, int productId);
    DataResult<List<ListOrderDetailResponse>> getAll(Integer pageNo, Integer pageSize);
    DataResult<List<ListOrderDetailResponse>> getAll(Integer pageNo, Integer pageSize,String field);
    DataResult<List<ListOrderDetailResponse>> getAll(Integer pageNo, Integer pageSize,String field,boolean state);
}
