package com.ozgursertel.Enoca.controller;

import com.ozgursertel.Enoca.entity.Cart;
import com.ozgursertel.Enoca.entity.Product;
import com.ozgursertel.Enoca.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping
    public List<Cart> getAll(){
        return cartService.findAll();
    }
    @GetMapping("/{id}")
    public Cart findById(@PathVariable Long id){
        return cartService.findById(id);
    }

    @PostMapping
    public Cart addCart(@RequestBody Cart cart){
        return cartService.save(cart);
    }

    @DeleteMapping
    public void deleteCart(@RequestBody Cart cart){
        cartService.delete(cart);
    }
    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id){
        cartService.delete(id);
    }

    @PostMapping("/add_customer/{cartId}-{customerId}")
    public Cart addCustomerToCart(@PathVariable Long cartId,@PathVariable Long customerId){
        return cartService.addCustomerToCart(cartId,customerId);
    }

    //Add Product To Cart
    @PutMapping("/add_product/{cartId}")
    public Cart addProductToCart(@PathVariable Long cartId,@RequestParam Long productId){
        return cartService.addProductToCart(cartId,productId);
    }
    //Add Products To Cart
    @PutMapping("/add_products/{cartId}")
    public Cart addProductToCart(@PathVariable Long cartId,@RequestBody List<Product> products){
        return cartService.addProductsToCart(cartId,products);
    }

    @PutMapping("/empty/{id}")
    public Cart emptyProduct(@PathVariable Long id){
        return cartService.emptyCart(id);
    }
}
