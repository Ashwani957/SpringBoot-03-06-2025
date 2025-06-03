package com.ecommerce.ProuductList.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String description ;
    private double price;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false) // in this table we it will create a new field that is category_id in which it sotre the data of the product
private Category category;
}
