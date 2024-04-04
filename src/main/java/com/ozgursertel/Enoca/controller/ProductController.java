package com.ozgursertel.Enoca.controller;

import com.ozgursertel.Enoca.entity.Product;
import com.ozgursertel.Enoca.entity.dto.ProductDto;
import com.ozgursertel.Enoca.mapper.ProductMapper;
import com.ozgursertel.Enoca.repository.ProductRepository;
import com.ozgursertel.Enoca.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    //Get Products
    @GetMapping
    public List<Product> getProducts(){
        return productService.getAll();
    }
    //Get Products by Range
    @GetMapping("/range/{min}-{max}")
    public List<Product> getProductsByRange(@PathVariable double min,@PathVariable double max){
        return productService.findProductByRange(min,max);
    }
    //Get Product By Name
    @GetMapping("/name/{name}")
    public Product getProductByName(@PathVariable String name){
        return productService.findByName(name);
    }
    //Get Product By ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.findById(id);
    }
    //Create Product
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.save(product);
    }
    //Update Product
    @PutMapping
    public Product partialUpdateProduct(@RequestBody ProductDto productDto){
        return productService.partialUpdate(productDto);
    }
    @PutMapping("/{id}")
    public Product partialUpdateProduct(@RequestBody ProductDto productDto,@PathVariable Long id){
        return productService.partialUpdate(productDto,id);
    }
    //Delete Product
    @DeleteMapping
    public void deleteProduct(@RequestBody Product product){
        productService.delete(product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.delete(productService.findById(id));
    }


}
