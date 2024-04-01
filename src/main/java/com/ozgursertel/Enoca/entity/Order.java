package com.ozgursertel.Enoca.entity;

import jakarta.persistence.*;


@Table(name = "orders")
@Entity
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

}
