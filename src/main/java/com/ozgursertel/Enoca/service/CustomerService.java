package com.ozgursertel.Enoca.service;

import com.ozgursertel.Enoca.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ozgursertel.Enoca.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Customer findById(long id){
        return customerRepository.findById(id).get();
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer){
        customerRepository.delete(customer);
    }
}
