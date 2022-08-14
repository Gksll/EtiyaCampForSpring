package com.etiya.northwind.business.concretes;
import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.orderDetailRequests.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetailRequests.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetailRequests.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.ListOrderDetailResponse;
import com.etiya.northwind.business.responses.orderDetails.ReadOrderDetailResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.Results.DataResult;
import com.etiya.northwind.core.utilities.Results.Result;
import com.etiya.northwind.core.utilities.Results.SuccessDataResult;
import com.etiya.northwind.core.utilities.Results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailsRepository;
import com.etiya.northwind.entities.concretes.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailManager implements OrderDetailService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public Result add(CreateOrderDetailRequest createOrderDetailRequest) {
        OrderDetail orderDetail = this.modelMapperService.forRequest().map(createOrderDetailRequest, OrderDetail.class);
        orderDetailsRepository.save(orderDetail);
        return new SuccessResult("Added successfully");
    }

    @Override
    public Result update(UpdateOrderDetailRequest updateOrderDetailRequest) {
        OrderDetail orderDetail = this.modelMapperService.forRequest().map(updateOrderDetailRequest, OrderDetail.class);
        orderDetailsRepository.save(orderDetail);
        return new SuccessResult("Updated successfully");
    }

    @Override
    public Result delete(DeleteOrderDetailRequest deleteOrderDetailRequest) {
        OrderDetail orderDetail = this.modelMapperService.forRequest().map(deleteOrderDetailRequest, OrderDetail.class);
        this.orderDetailsRepository.deleteOrderDetailWithOrderIdAndProductId(orderDetail.getOrder().getOrderId(), orderDetail.getProduct().getProductId());
        return new SuccessResult("Deleted successfully");
    }

    @Override
    public DataResult<List<ListOrderDetailResponse>> getAll() {
        List<OrderDetail> result = this.orderDetailsRepository.findAll();
        List<ListOrderDetailResponse> response =
                result.stream().map(orderDetail -> this.modelMapperService.forResponse().map(orderDetail, ListOrderDetailResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<ListOrderDetailResponse>>(response,"Listed Successfully");
    }

    @Override
    public DataResult<ReadOrderDetailResponse> getById(int orderId, int productId) {
        OrderDetail orderDetail = this.orderDetailsRepository.getByOrder_OrderIdAndProduct_ProductId(orderId, productId);
        ReadOrderDetailResponse response = this.modelMapperService.forResponse().map(orderDetail, ReadOrderDetailResponse.class);
        return new SuccessDataResult<ReadOrderDetailResponse>(response,"Listed Successfully");
    }


    @Override
    public DataResult<List<ListOrderDetailResponse>> getAll(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        List<OrderDetail> orderDetails = this.orderDetailsRepository.findAll(pageable).getContent();
        List<ListOrderDetailResponse> responces = orderDetails.stream()
                .map(item -> modelMapperService.forResponse().map(item, ListOrderDetailResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListOrderDetailResponse>>(responces,"Listed Successfully");
    }

    @Override
    public DataResult<List<ListOrderDetailResponse>> getAll(Integer pageNo, Integer pageSize, String field) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,Sort.by(field));
        List<OrderDetail> orderDetails = this.orderDetailsRepository.findAll(pageable).getContent();
        List<ListOrderDetailResponse> responces = orderDetails.stream()
                .map(item -> modelMapperService.forResponse().map(item, ListOrderDetailResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListOrderDetailResponse>>(responces,"Listed Successfully");
    }

    @Override
    public DataResult<List<ListOrderDetailResponse>> getAll(Integer pageNo, Integer pageSize, String field, boolean isStateDescending) {
        Pageable pageable = checkAscendingOrDescending(pageNo,pageSize,field,isStateDescending);
        List<OrderDetail> orderDetails = this.orderDetailsRepository.findAll(pageable).getContent();
        List<ListOrderDetailResponse> responces = orderDetails.stream()
                .map(item -> modelMapperService.forResponse().map(item, ListOrderDetailResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListOrderDetailResponse>>(responces,"Listed Successfully");
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
}