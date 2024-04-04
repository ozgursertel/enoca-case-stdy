package com.ozgursertel.Enoca.controller;

import com.ozgursertel.Enoca.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ozgursertel.Enoca.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> findAll(){
        return customerService.getAll();
    }
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id){
        return customerService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        customerService.deleteCustomer(customerService.findById(id));
    }

    @DeleteMapping
    public void delete(@RequestBody Customer customer){
        customerService.deleteCustomer(customer);
    }
}
