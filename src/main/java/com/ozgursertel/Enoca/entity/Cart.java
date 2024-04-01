package com.ozgursertel.Enoca.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart extends BaseEntity{
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToMany(mappedBy = "cartInProduct")
    Set<Product> productInCart;

    @OneToOne(mappedBy = "cart")
    private Order order;
}
