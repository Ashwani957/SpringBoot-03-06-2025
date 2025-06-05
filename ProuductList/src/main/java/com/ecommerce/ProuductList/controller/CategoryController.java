package com.ecommerce.ProuductList.controller;


import com.ecommerce.ProuductList.dto.CategoryDTO;
import com.ecommerce.ProuductList.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

//    get product

    /*

    This will provide the default status while we run the status code
   @PostMapping
    public CategoryDTO createCategory( @RequestBody CategoryDTO categoryDTO)
   {
       return categoryService.createCategory(categoryDTO);

   }

     */


//    Here we want to update the status code according to our needed

//    1.createCategory
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO)
    {
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);

    }

//    2.get all the category
@GetMapping
    public List<CategoryDTO> getAllCategories(){

        return categoryService.getAllCategories();
    }

// get Category by Id


    @GetMapping("/{id}")
    public CategoryDTO getCategoriesById(@PathVariable  Long id ){
        return categoryService.getCategoriesById(id);
    }



    //delete product

    @DeleteMapping("/{id}")
    public String  deletecategoryByid(@PathVariable Long id )
    {

        return  categoryService.deletecategoryById(id);

    }


}
