package com.etiya.northwind.dataAccess.abstracts;

import com.etiya.northwind.entities.concretes.CartInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartInvoiceRepository extends JpaRepository<CartInvoice , Integer> {

}
