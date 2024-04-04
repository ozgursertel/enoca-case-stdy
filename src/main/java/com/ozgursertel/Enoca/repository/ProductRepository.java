package com.ozgursertel.Enoca.repository;

import com.ozgursertel.Enoca.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    Optional<Product> findById(Long aLong);

    @Override
    List<Product> findAll();

    @Override
    Product save(Product product);

    @Override
    void delete(Product entity);

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    Product findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max")
    List<Product> findProductByRange(double min,double max);


}
