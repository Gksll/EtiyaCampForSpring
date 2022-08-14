package com.etiya.northwind.api.controllers;

import java.util.List;

import com.etiya.northwind.core.utilities.Results.DataResult;
import com.etiya.northwind.core.utilities.Results.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CartService;
import com.etiya.northwind.business.requests.cart.CreateCartRequest;
import com.etiya.northwind.business.requests.cart.DeleteCartRequest;
import com.etiya.northwind.business.requests.cart.UpdateCartRequest;
import com.etiya.northwind.business.responses.carts.CartListResponse;
import com.etiya.northwind.business.responses.carts.CartReadResponse;

@RestController
@RequestMapping("/api/carts")
public class CartsController {
	private CartService cartService;
	
	public CartsController(CartService cartService) {
		this.cartService = cartService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateCartRequest createCartRequest) {
		return this.cartService.add(createCartRequest);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteCartRequest deletCartRequest) {
		return this.cartService.delete(deletCartRequest);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody UpdateCartRequest updaCartRequest) {
		return this.cartService.update(updaCartRequest);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CartReadResponse> getById(@RequestParam int id) {
		return this.cartService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CartListResponse>> getAll() {
		return this.cartService.getAll();
	}
}
