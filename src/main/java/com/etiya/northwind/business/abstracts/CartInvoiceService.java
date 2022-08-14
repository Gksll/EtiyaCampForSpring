package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.cartInvoices.CreateCartInvoiceRequest;
import com.etiya.northwind.business.requests.cartInvoices.DeleteCartInvoiceRequest;
import com.etiya.northwind.business.requests.cartInvoices.UpdateCartInvoiceRequest;
import com.etiya.northwind.business.responses.cartInvoices.CartInvoiceListResponse;
import com.etiya.northwind.business.responses.cartInvoices.CartInvoiceReadResponse;
import com.etiya.northwind.core.utilities.Results.DataResult;
import com.etiya.northwind.core.utilities.Results.Result;

public interface CartInvoiceService {
    Result add(CreateCartInvoiceRequest createCartInvoiceRequest);
    Result update(UpdateCartInvoiceRequest updateCartInvoiceRequest);
    Result delete(DeleteCartInvoiceRequest deleteCartInvoiceRequest);
    DataResult<CartInvoiceReadResponse> getById(int cartInvoiceId);
    DataResult<List<CartInvoiceListResponse>> getAll();
}
