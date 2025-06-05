package com.ecommerce.ProuductList.dto;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {


    private    Long id;
    private String name;
    private String description ;
    private Double price ;
    private Long categoryId;

}
