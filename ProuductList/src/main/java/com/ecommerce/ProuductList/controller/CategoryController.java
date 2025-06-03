package com.ecommerce.ProuductList.controller;


import com.ecommerce.ProuductList.dto.CategoryDTO;
import com.ecommerce.ProuductList.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO)
    {
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }




    //create proudct
    //update product
    //get product by id
    //delete product


}
