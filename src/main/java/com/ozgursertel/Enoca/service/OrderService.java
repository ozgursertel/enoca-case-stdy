package com.ozgursertel.Enoca.service;

import com.ozgursertel.Enoca.entity.Cart;
import com.ozgursertel.Enoca.entity.Customer;
import com.ozgursertel.Enoca.entity.Order;
import com.ozgursertel.Enoca.repository.CartRepository;
import com.ozgursertel.Enoca.repository.CustomerRepository;
import com.ozgursertel.Enoca.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CartRepository cartRepository;

    public Order placeOrder(Order order){
        return orderRepository.save(order);
    }

    public Order placeOrder(Customer customer, Cart cart){
        Order order = new Order();
        order.setCustomer(customer);
        order.setCart(cart);
        return orderRepository.save(order);
    }

    public Order placeOrder(Long customerId, Long cartId){
        Order order = new Order();
        order.setCustomer(customerRepository.findById(customerId).get());
        order.setCart(cartRepository.findById(cartId).get());
        return orderRepository.save(order);
    }

    public Order placeOrder(Long customerId){
        Order order = new Order();
        order.setCustomer(customerRepository.findById(customerId).get());
        order.setCart(customerRepository.findById(customerId).get().getCart());
        return orderRepository.save(order);
    }

    public Order getOrderForCode(Long id){
        return orderRepository.findById(id).get();
    }

    public List<Order> getAllOrdersForCustomer(Long customerId){
        return orderRepository.findByCustomerId(customerId);
    }
}
