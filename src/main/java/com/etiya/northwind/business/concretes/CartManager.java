package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import com.etiya.northwind.core.utilities.Results.DataResult;
import com.etiya.northwind.core.utilities.Results.Result;
import com.etiya.northwind.core.utilities.Results.SuccessDataResult;
import com.etiya.northwind.core.utilities.Results.SuccessResult;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CartService;
import com.etiya.northwind.business.requests.cart.CreateCartRequest;
import com.etiya.northwind.business.requests.cart.DeleteCartRequest;
import com.etiya.northwind.business.requests.cart.UpdateCartRequest;
import com.etiya.northwind.business.responses.carts.CartListResponse;
import com.etiya.northwind.business.responses.carts.CartReadResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CartRepository;
import com.etiya.northwind.entities.concretes.Cart;

@Service
public class CartManager implements CartService {
	private CartRepository cartRepository;
	private ModelMapperService modelMapperService;
	
	
    public CartManager(CartRepository cartRepository, ModelMapperService modelMapperService) {
		this.cartRepository = cartRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
    public Result add(CreateCartRequest createCartRequest) {
   		Cart cart = this.modelMapperService.forRequest().map(createCartRequest, Cart.class);
		this.cartRepository.save(cart);
    	return new SuccessResult("Added");
    }

    @Override
    public Result update(UpdateCartRequest updateCartRequest) {
        Cart cart = this.modelMapperService.forRequest().map(updateCartRequest, Cart.class);
    	this.cartRepository.save(cart);
    	return new SuccessResult("Updated");
    }

    @Override
    public Result delete(DeleteCartRequest deleteCartRequest) {
        this.cartRepository.deleteById(deleteCartRequest.getCartId());
        return new SuccessResult("Deleted");
    }

    @Override
    public DataResult<CartReadResponse> getById(int cartId) {
        Cart cart = this.cartRepository.findById(cartId).get();
        CartReadResponse response = this.modelMapperService.forResponse().map(cart, CartReadResponse.class);
        return new SuccessDataResult<CartReadResponse>(response);
    }

    @Override
    public DataResult<List<CartListResponse>> getAll() {
    	List<Cart> carts = this.cartRepository.findAll();
    	List<CartListResponse> response = carts.stream().map(cart-> this.modelMapperService
    			.forRequest().map(cart, CartListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(response);
    }

}
