package com.ozgursertel.Enoca.service;

import com.ozgursertel.Enoca.entity.Product;
import com.ozgursertel.Enoca.entity.dto.ProductDto;
import com.ozgursertel.Enoca.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ozgursertel.Enoca.repository.ProductRepository;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Autowired
    public void setProductMapper(ProductMapper productMapper){
        this.productMapper = productMapper;
    }
    
    

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

    public Product partialUpdate(ProductDto dto){
        Date d = new Date();
        dto.setUpdatedAt(d);
        Product product = findById(dto.getId());
        return save( productMapper.updateProductFromDto(dto,product));
    }
    public Product partialUpdate(ProductDto dto,long id){
        Date d = new Date();
        dto.setUpdatedAt(d);
        Product product = findById(dto.getId());
        return save(productMapper.updateProductFromDto(dto,product));
    }

    public List<Product> findProductByRange(double min, double max) {
       return productRepository.findProductByRange(min,max);
    }

    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    public void delete(Product product) {
         productRepository.delete(product);
    }
}
