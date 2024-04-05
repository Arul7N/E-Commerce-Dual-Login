package com.example.OrderService.Controller;

import com.example.OrderService.Model.Order;
import com.example.OrderService.Service.JwtService;
import com.example.OrderService.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private JwtService jwtService;

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("/place")
    public ResponseEntity<String> placeAnOrder(@RequestBody Order order) throws Exception {
        service.placeOrder(order);
        return new ResponseEntity<>("Order Placed...!", HttpStatus.OK);
    }

    @PostMapping("/user-name")
    public String loggedName(@RequestBody String token){
        return jwtService.extractUsername(token);
    }
}
