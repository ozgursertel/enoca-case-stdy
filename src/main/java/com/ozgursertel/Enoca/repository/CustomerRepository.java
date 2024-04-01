package com.ozgursertel.Enoca.repository;

import com.ozgursertel.Enoca.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Override
    List<Customer> findAll();
    @Override
    Optional<Customer> findById(Long aLong);

    @Override
    <S extends Customer> S save(S entity);

    @Override
    void delete(Customer entity);
}
