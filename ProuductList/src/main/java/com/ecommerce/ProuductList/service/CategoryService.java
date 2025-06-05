package com.ecommerce.ProuductList.service;


import com.ecommerce.ProuductList.dto.CategoryDTO;
import com.ecommerce.ProuductList.entity.Category;
import com.ecommerce.ProuductList.entity.Product;
import com.ecommerce.ProuductList.mapper.CategoryMapper;
import com.ecommerce.ProuductList.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

// we can also write the autowired here but now we can use the allargsconsturctor
    private CategoryRepository categoryrepo;


//    createCategory


    public CategoryDTO createCategory(CategoryDTO categoryDTO)
    {
//Here we convert the category dto into entity and save it into the datbase after save we futhre convert the entity of dto
        Category category=CategoryMapper.toCategoryEntity(categoryDTO);
      category= categoryrepo.save(category);
      CategoryMapper.tocategoryDTO(category);
return CategoryMapper.tocategoryDTO(category);

    }

//get all category

    public List<CategoryDTO> getAllCategories(){
//        this will find the data form the database and return the enity and we need to convert the entity into doto and then we reutrn back

//        Here we get the data from the database and the data that i get from the database in the form of the entity  so we need to convert it into the  dto withe the help of steam

       return  categoryrepo.findAll().stream().map(CategoryMapper::tocategoryDTO).toList();


    }


//    get Category By Id

    public CategoryDTO getCategoriesById(Long id ){
       Category category= categoryrepo.findById(id).orElseThrow(()->new RuntimeException("Cateogyr not found "));
       return CategoryMapper.tocategoryDTO(category);
    }

//    Delete the category

    public String  deletecategoryById(Long id ){
        categoryrepo.deleteById(id);
return "Categories Deleted Succesfully";
    }


}
