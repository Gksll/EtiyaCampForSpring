package com.etiya.northwind.dataAccess.abstracts;

import com.etiya.northwind.entities.concretes.OrderDetail;
import com.etiya.northwind.entities.concretes.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface OrderDetailsRepository extends JpaRepository<OrderDetail, OrderDetailId> {
    OrderDetail getByOrder_OrderIdAndProduct_ProductId( int orderId,int productId);

    @Transactional
    @Modifying
    @Query("Delete From OrderDetail  Where order_id =:orderId and product_id =:productId")
    void deleteOrderDetailWithOrderIdAndProductId(@Param("orderId")int orderId, @Param("productId")int productId);
}
