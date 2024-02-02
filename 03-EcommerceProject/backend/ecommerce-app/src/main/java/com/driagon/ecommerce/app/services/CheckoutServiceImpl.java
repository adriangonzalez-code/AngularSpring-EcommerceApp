package com.driagon.ecommerce.app.services;

import com.driagon.ecommerce.app.dto.Purchase;
import com.driagon.ecommerce.app.dto.PurchaseResponse;
import com.driagon.ecommerce.app.entities.Customer;
import com.driagon.ecommerce.app.entities.Order;
import com.driagon.ecommerce.app.entities.OrderItem;
import com.driagon.ecommerce.app.repositories.ICustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements ICheckoutService {

    private ICustomerRepository customerRepository;

    public CheckoutServiceImpl(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // Retrieve the order info from dto
        Order order = purchase.getOrder();

        // Generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // Populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(order::add);

        // Populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddres());

        // Populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        // Save to the database
        this.customerRepository.save(customer);

        // Return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // Generate a random UUID number (UUID version-4)

        return UUID.randomUUID().toString();
    }
}