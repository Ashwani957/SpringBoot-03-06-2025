package com.ecommerce.ProuductList.mapper;

import com.ecommerce.ProuductList.dto.ProductDTO;
import com.ecommerce.ProuductList.entity.Category;
import com.ecommerce.ProuductList.entity.Product;

public class ProductMapper {


//    entity to dto conversion
    public static ProductDTO toProductDTO(Product product)
    {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );

    }
//    DTO to entity
    public static Product toProductEntity(ProductDTO productDTO, Category category)
    {

        Product product =new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        return product ;


    }


}
