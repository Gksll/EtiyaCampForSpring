package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.cartItems.CreateCartItemsRequest;
import com.etiya.northwind.business.requests.cartItems.DeleteCartItemsRequest;
import com.etiya.northwind.business.requests.cartItems.UpdateCartItemsRequest;
import com.etiya.northwind.business.responses.cartItems.CartItemsListResponse;
import com.etiya.northwind.business.responses.cartItems.CartItemsReadResponse;
import com.etiya.northwind.core.utilities.Results.DataResult;
import com.etiya.northwind.core.utilities.Results.Result;

public interface CartItemService {
    Result add(CreateCartItemsRequest createCartItemRequest);
    Result update(UpdateCartItemsRequest updateCartItemsRequest);
    Result delete(DeleteCartItemsRequest deleteCartItemsRequest);
    DataResult<CartItemsReadResponse> getById(int cartItemId);
    DataResult<List<CartItemsListResponse>> getAll();
}
