package com.driagon.ecommerce.app.services;

import com.driagon.ecommerce.app.dto.Purchase;
import com.driagon.ecommerce.app.dto.PurchaseResponse;

public interface ICheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}