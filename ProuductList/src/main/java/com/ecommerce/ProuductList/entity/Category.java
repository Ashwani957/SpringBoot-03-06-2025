package com.ecommerce.ProuductList.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;
    private String name ;

//    Here one to many relationship because one category like electronic have mulitple proudcts

    @OneToMany(mappedBy="category", cascade=CascadeType.ALL)

    private List<Product> products =new ArrayList<>();


}
