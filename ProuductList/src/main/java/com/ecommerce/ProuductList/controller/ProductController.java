package com.ecommerce.ProuductList.controller;


import com.ecommerce.ProuductList.dto.ProductDTO;
import com.ecommerce.ProuductList.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController
{

    private ProductService productService;
//    create product  : with 200 k ok stauts
//    @PostMapping
//    public ProductDTO createProduct (@RequestBody ProductDTO productDTO){
//
////        we write all the logic in service layer to create a product
//      return   productService.createProduct(productDTO);
//    }


//create product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct (@RequestBody ProductDTO productDTO){
//        we write all the logic in service layer to create a product
      ProductDTO productdto=  productService.createProduct(productDTO);
      return new ResponseEntity<>(productdto, HttpStatus.CREATED);


    }

//    get all product
    @GetMapping
    public List<ProductDTO> getallProduct(){
          return   productService.getallProduct();
    }



//    get product by id

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
         return productService.getProductByid(id);
    }

//    get delete by id
    @DeleteMapping("/{id}")
    public String deletebyid(@PathVariable Long id){
 return        productService.deleteProductById(id);

    }

//    update the product

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable long id, @RequestBody ProductDTO productDTO)
    {
        return productService.updateProduct(id,productDTO);


    }







}
