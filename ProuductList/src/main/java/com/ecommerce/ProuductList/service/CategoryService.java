package com.ecommerce.ProuductList.service;


import com.ecommerce.ProuductList.dto.CategoryDTO;
import com.ecommerce.ProuductList.entity.Category;
import com.ecommerce.ProuductList.mapper.CategoryMapper;
import com.ecommerce.ProuductList.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

// we can also write the autowired here but now we can use the allargsconsturctor
    private CategoryRepository categoryrepo;


//    createCategory


    public CategoryDTO createCategory(CategoryDTO categoryDTO)
    {
        Category category=CategoryMapper.toCategoryEntity(categoryDTO);
      category= categoryrepo.save(category);
      CategoryMapper.tocategoryDTO(category);
return CategoryMapper.tocategoryDTO(category);

    }



    // get all category
    //get category by id
    //delete category


}
