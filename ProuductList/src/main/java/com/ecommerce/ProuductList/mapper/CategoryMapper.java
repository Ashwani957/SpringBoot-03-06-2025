package com.ecommerce.ProuductList.mapper;

import com.ecommerce.ProuductList.dto.CategoryDTO;
import com.ecommerce.ProuductList.entity.Category;

public class CategoryMapper {




//    entity to dto
    public static CategoryDTO tocategoryDTO(Category category)
    {
        if(category==null)
        {
            return null ;
        }
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProducts(category.getProducts().stream().map(ProductMapper::toProductDTO).toList());
        return categoryDTO;
    }


//    dtp to entity

    public static Category toCategoryEntity(CategoryDTO categoryDTO)
    {
        Category category=new Category();
        category.setName(categoryDTO.getName());
        return category;
    }


}
