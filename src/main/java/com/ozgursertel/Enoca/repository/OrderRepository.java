package com.ozgursertel.Enoca.repository;

import com.ozgursertel.Enoca.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Override
    List<Order> findAll();

    @Override
    Optional<Order> findById(Long aLong);

    @Override
    <S extends Order> S save(S entity);

    @Override
    void delete(Order entity);

    @Query("SELECT o FROM Order o WHERE o.customer.id = :customerId ")
    List<Order> findByCustomerId(Long customerId);
}
