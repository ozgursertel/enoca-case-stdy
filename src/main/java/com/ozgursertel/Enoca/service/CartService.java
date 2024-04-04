package com.ozgursertel.Enoca.service;

import com.ozgursertel.Enoca.entity.Cart;
import com.ozgursertel.Enoca.entity.Product;
import com.ozgursertel.Enoca.repository.CartRepository;
import com.ozgursertel.Enoca.repository.CustomerRepository;
import com.ozgursertel.Enoca.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<Cart> findAll(){
        return cartRepository.findAll();
    }
    public Cart findById(Long id){
        return cartRepository.findById(id).get();
    }

    public Cart save(Cart cart){
        return cartRepository.save(cart);
    }

    public void delete(Cart cart){
        cartRepository.delete(cart);
    }
    public void delete(Long id){
        cartRepository.delete(cartRepository.findById(id).get());
    }

    public Cart addCustomerToCart(Long cartId, Long customerId) {
        Cart cart = cartRepository.findById(cartId).get();
        cart.setCustomer(customerRepository.findById(customerId).get());
        return save(cart);
    }

    public Cart addProductToCart(Long cartId,Long productId){
        Cart cart = cartRepository.findById(cartId).get();
        cart.getProductInCart().add(productRepository.findById(productId).get());
        return cartRepository.save(cart);
    }
    public Cart addProductsToCart(Long cartId,List<Product> products){
        Cart cart = cartRepository.findById(cartId).get();
        cart.getProductInCart().addAll(products);
        return cartRepository.save(cart);
    }

    public Cart emptyCart(Long cartId){
        Cart cart = cartRepository.findById(cartId).get();
        cart.setProductInCart(null);
        return cartRepository.save(cart);
    }
}
