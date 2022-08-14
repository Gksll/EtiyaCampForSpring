package com.etiya.northwind.api.controllers;

import java.util.List;

import com.etiya.northwind.business.requests.cartInvoices.CreateCartInvoiceRequest;
import com.etiya.northwind.business.requests.cartInvoices.DeleteCartInvoiceRequest;
import com.etiya.northwind.business.requests.cartInvoices.UpdateCartInvoiceRequest;
import com.etiya.northwind.business.responses.cartInvoices.CartInvoiceListResponse;
import com.etiya.northwind.business.responses.cartInvoices.CartInvoiceReadResponse;
import com.etiya.northwind.core.utilities.Results.DataResult;
import com.etiya.northwind.core.utilities.Results.Result;
import com.etiya.northwind.core.utilities.Results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CartInvoiceService;

@RestController
@RequestMapping("/api/cartInvoices")
public class CartInvoicesController {
	private CartInvoiceService cartInvoiceService;
	
	@Autowired
	public CartInvoicesController(CartInvoiceService cartInvoiceService) {
		this.cartInvoiceService = cartInvoiceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateCartInvoiceRequest createCartInvoiceRequest) {
		 this.cartInvoiceService.add(createCartInvoiceRequest);
		return new SuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteCartInvoiceRequest deleteCartInvoiceRequest) {
		 this.cartInvoiceService.delete(deleteCartInvoiceRequest);
		return new SuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody UpdateCartInvoiceRequest updateCartInvoiceRequest) {
		 this.cartInvoiceService.update(updateCartInvoiceRequest);
		return new SuccessResult();
	}

	@GetMapping("/getbyid")
	public DataResult<CartInvoiceReadResponse> getById(@RequestParam int id) {
		return this.cartInvoiceService.getById(id);
	}

	@GetMapping("/getall")
	public DataResult<List<CartInvoiceListResponse>> getAll() {
		return this.cartInvoiceService.getAll();
	}
}
