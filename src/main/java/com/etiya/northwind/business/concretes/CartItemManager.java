package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CartItemService;
import com.etiya.northwind.business.requests.cartItems.CreateCartItemsRequest;
import com.etiya.northwind.business.requests.cartItems.DeleteCartItemsRequest;
import com.etiya.northwind.business.requests.cartItems.UpdateCartItemsRequest;
import com.etiya.northwind.business.responses.cartItems.CartItemsListResponse;
import com.etiya.northwind.business.responses.cartItems.CartItemsReadResponse;
import com.etiya.northwind.core.utilities.Results.DataResult;
import com.etiya.northwind.core.utilities.Results.Result;
import com.etiya.northwind.core.utilities.Results.SuccessDataResult;
import com.etiya.northwind.core.utilities.Results.SuccessResult;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CartItemRepository;
import com.etiya.northwind.entities.concretes.CartItem;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class CartItemManager implements CartItemService {
	private ModelMapperService modelMapperService;
	private CartItemRepository cartItemRepository;
	
	
    public CartItemManager(ModelMapperService modelMapperService, CartItemRepository cartItemRepository) {
		this.modelMapperService = modelMapperService;
		this.cartItemRepository = cartItemRepository;
	}

	@Override
    public Result add(CreateCartItemsRequest createCartItemRequest) {
    	CartItem cartItem = this.modelMapperService.forRequest().map(createCartItemRequest, CartItem.class);
    	this.cartItemRepository.save(cartItem);
        return new SuccessResult("Added");
    }

    @Override
    public Result update(UpdateCartItemsRequest updateCartItemsRequest) {
    	CartItem cartItem = this.modelMapperService.forRequest().map(updateCartItemsRequest, CartItem.class);
    	this.cartItemRepository.save(cartItem);
        return new SuccessResult("Updated");
    }

    @Override
    public Result delete(DeleteCartItemsRequest deleteCartItemsRequest) {
    	this.cartItemRepository.deleteById(deleteCartItemsRequest.getCartItemId());
    	
        return new SuccessResult("Deleted");
    }

    @Override
    public DataResult<CartItemsReadResponse> getById(int cartItemId) {
    	CartItem cartItem = this.cartItemRepository.findById(cartItemId).get();
    	CartItemsReadResponse response = this.modelMapperService.forResponse().map(cartItem, CartItemsReadResponse.class);
        
    	return new SuccessDataResult<>(response);
    }

    @Override
    public DataResult<List<CartItemsListResponse>> getAll() {
    	List<CartItem> cartItemsListResponses = this.cartItemRepository.findAll();
    	List<CartItemsListResponse> responses = cartItemsListResponses.stream().map(cartItem-> this.modelMapperService.forResponse()
    			.map(cartItem, CartItemsListResponse.class)).collect(Collectors.toList());
        	
    	return new SuccessDataResult<List<CartItemsListResponse>>(responses);
    }
}
