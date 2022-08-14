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

import com.etiya.northwind.business.abstracts.CartItemService;
import com.etiya.northwind.business.requests.cartItems.CreateCartItemsRequest;
import com.etiya.northwind.business.requests.cartItems.DeleteCartItemsRequest;
import com.etiya.northwind.business.requests.cartItems.UpdateCartItemsRequest;
import com.etiya.northwind.business.responses.cartItems.CartItemsListResponse;
import com.etiya.northwind.business.responses.cartItems.CartItemsReadResponse;

@RestController
@RequestMapping("/api/cartItems")
public class CartItemsController {
private CartItemService cartItemService;
	
	public CartItemsController(CartItemService cartItemService) {
		this.cartItemService = cartItemService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateCartItemsRequest createCartItemsRequest) {
		return this.cartItemService.add(createCartItemsRequest);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteCartItemsRequest deleteCartItemsRequest) {
		return this.cartItemService.delete(deleteCartItemsRequest);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody UpdateCartItemsRequest updateCartItemsRequest) {
		return this.cartItemService.update(updateCartItemsRequest);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CartItemsReadResponse> getById(@RequestParam int id) {
		return this.cartItemService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CartItemsListResponse>> getAll() {
		return this.cartItemService.getAll();
	}
}
