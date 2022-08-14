package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cart_invoices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartInvoice {
    @Id
    @Column(name = "cart_invoice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartInvoiceId;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(name = "total_price")
    private double totalPrice;
}
