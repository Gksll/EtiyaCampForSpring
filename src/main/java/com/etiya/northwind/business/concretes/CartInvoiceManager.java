package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import com.etiya.northwind.business.responses.cartItems.CartItemsListResponse;
import com.etiya.northwind.business.responses.cartItems.CartItemsReadResponse;
import com.etiya.northwind.core.utilities.Results.DataResult;
import com.etiya.northwind.core.utilities.Results.Result;
import com.etiya.northwind.core.utilities.Results.SuccessDataResult;
import com.etiya.northwind.core.utilities.Results.SuccessResult;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CartInvoiceService;
import com.etiya.northwind.business.requests.cartInvoices.CreateCartInvoiceRequest;
import com.etiya.northwind.business.requests.cartInvoices.DeleteCartInvoiceRequest;
import com.etiya.northwind.business.requests.cartInvoices.UpdateCartInvoiceRequest;
import com.etiya.northwind.business.responses.cartInvoices.CartInvoiceListResponse;
import com.etiya.northwind.business.responses.cartInvoices.CartInvoiceReadResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CartInvoiceRepository;
import com.etiya.northwind.dataAccess.abstracts.CartItemRepository;
import com.etiya.northwind.entities.concretes.CartInvoice;
import com.etiya.northwind.entities.concretes.CartItem;

@Service
public class CartInvoiceManager implements CartInvoiceService {
    private ModelMapperService modelMapperService;
    private CartInvoiceRepository cartInvoiceRepository;
    private CartItemRepository cartItemRepository;

    public CartInvoiceManager(ModelMapperService modelMapperService, CartInvoiceRepository cartInvoiceRepository) {
        this.modelMapperService = modelMapperService;
        this.cartInvoiceRepository = cartInvoiceRepository;
    }

    @Override
    public Result add(CreateCartInvoiceRequest createCartInvoiceRequest) {
        CartInvoice cartInvoice = this.modelMapperService.forRequest().map(createCartInvoiceRequest, CartInvoice.class);
        cartInvoice.setTotalPrice(totalPrice(createCartInvoiceRequest.getCartId()));
        this.cartInvoiceRepository.save(cartInvoice);
        return new SuccessResult("Added");
    }

    @Override
    public Result update(UpdateCartInvoiceRequest updateCartInvoiceRequest) {
        CartInvoice cartInvoice = this.modelMapperService.forRequest().map(updateCartInvoiceRequest, CartInvoice.class);
        this.cartInvoiceRepository.save(cartInvoice);
        return new SuccessResult("Updated");

    }

    @Override
    public Result delete(DeleteCartInvoiceRequest deleteCartInvoiceRequest) {
        CartInvoice cartInvoice = this.modelMapperService.forRequest().map(deleteCartInvoiceRequest, CartInvoice.class);
        this.cartInvoiceRepository.delete(cartInvoice);
        return new SuccessResult("Deleted");
    }

    @Override
    public DataResult<CartInvoiceReadResponse> getById(int cartInvoiceId) {

        CartInvoice cartInvoice = this.cartInvoiceRepository.findById(cartInvoiceId).get();
        CartInvoiceReadResponse response = this.modelMapperService.forResponse().map(cartInvoice, CartInvoiceReadResponse.class);
        return new SuccessDataResult<CartInvoiceReadResponse>(response,"Listed");

    }

    @Override
    public DataResult<List<CartInvoiceListResponse>> getAll() {
        List<CartInvoice> cartInvoiceListResponses = this.cartInvoiceRepository.findAll();
        List<CartInvoiceListResponse> responses = cartInvoiceListResponses.stream().map(cartInvoice-> this.modelMapperService.forResponse()
                .map(cartInvoice, CartInvoiceListResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<CartInvoiceListResponse>>(responses,"Listed");

    }

    private double totalPrice(int cartId) {
        List<CartItem> cartItems = this.cartItemRepository.getByCartCartId(cartId);
        double totalPrice = 0;
        for (CartItem item : cartItems) {
            totalPrice += item.getUnitPrice() * item.getQuantity();
        }
        return totalPrice;
    }
}
