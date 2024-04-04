package com.ozgursertel.Enoca.controller;

import com.ozgursertel.Enoca.entity.Cart;
import com.ozgursertel.Enoca.entity.Customer;
import com.ozgursertel.Enoca.entity.Order;
import com.ozgursertel.Enoca.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    //Place Order With Order
    @PostMapping("/place")
    public Order placeOrder(@RequestBody Order order){
        return orderService.placeOrder(order);
    }
    //Place Order With Customer And Cart
    @PostMapping("/place/customer_cart")
    public Order placeOrder(@RequestBody Customer customer,@RequestBody Cart cart){
        return orderService.placeOrder(customer,cart);
    }

    //Place Order With Customer ID and Cart ID
    @PostMapping("/place/{customerId}")
    public Order placeOrder(@PathVariable Long customerId){
        return orderService.placeOrder(customerId);
    }

    @PostMapping("/place/{customerId}/{cartId}")
    public Order placeOrder(@PathVariable Long customerId,@PathVariable Long cartId){
        return orderService.placeOrder(customerId,cartId);
    }

    //Get Order For Code
    @GetMapping("/{id}")
    public Order getOrderForCode(@PathVariable Long id){
        return orderService.getOrderForCode(id);
    }

    //Get All Orders For Customer
    @GetMapping("/customer/{customerId}")
    public List<Order> getAllOrdersForCustomer(@PathVariable Long customerId){
        return orderService.getAllOrdersForCustomer(customerId);
    }

}
