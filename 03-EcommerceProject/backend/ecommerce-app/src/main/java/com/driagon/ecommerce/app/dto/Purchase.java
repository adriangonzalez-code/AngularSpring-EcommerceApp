package com.driagon.ecommerce.app.dto;

import com.driagon.ecommerce.app.entities.Address;
import com.driagon.ecommerce.app.entities.Customer;
import com.driagon.ecommerce.app.entities.Order;
import com.driagon.ecommerce.app.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

    private Customer customer;
    private Address shippingAddres;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}