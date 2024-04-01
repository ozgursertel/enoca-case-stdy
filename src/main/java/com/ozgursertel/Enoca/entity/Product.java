package com.ozgursertel.Enoca.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;
@Table(name = "product")
@Entity
public class Product extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name = "created_at")
    private Date createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToMany
    @JoinTable(
            name = "product_cart",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id"))
    @JsonIgnore
    Set<Cart> cartInProduct;

}
