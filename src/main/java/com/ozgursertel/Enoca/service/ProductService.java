package com.ozgursertel.Enoca.service;

import com.ozgursertel.Enoca.entity.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ozgursertel.Enoca.repository.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product findById(long id){
        return productRepository.findById(id).get();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Product product){
        productRepository.delete(product);
    }
}
