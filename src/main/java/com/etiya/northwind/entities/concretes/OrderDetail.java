package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="order_details")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(OrderDetailId.class)
public class OrderDetail {

    @Id
    @Column(name = "order_id")
    private int orderId;
    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false,updatable = false)
    private Order order;

    @Id
    @Column(name = "product_id")
    private int productId;
    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false,updatable = false)
    private Product product;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="quantity")
    private int quantity;

    @Column(name="discount")
    private double discount;
}
