package com.ozgursertel.Enoca.repository;

import com.ozgursertel.Enoca.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    @Override
    List<Cart> findAll();

    @Override
    Optional<Cart> findById(Long aLong);

    @Override
    <S extends Cart> S save(S entity);

    @Override
    void delete(Cart entity);
}
