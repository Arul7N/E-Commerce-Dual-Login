package com.example.OrderService.Service;

import com.example.OrderService.Model.Order;

public interface OrderService {

    public Order placeOrder(Order order) throws Exception;
}
