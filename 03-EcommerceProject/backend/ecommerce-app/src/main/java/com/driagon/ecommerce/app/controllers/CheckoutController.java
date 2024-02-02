package com.driagon.ecommerce.app.controllers;

import com.driagon.ecommerce.app.dto.Purchase;
import com.driagon.ecommerce.app.dto.PurchaseResponse;
import com.driagon.ecommerce.app.services.ICheckoutService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private ICheckoutService checkoutService;

    public CheckoutController(ICheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = this.checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }
}