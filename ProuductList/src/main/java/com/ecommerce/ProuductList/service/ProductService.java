package com.ecommerce.ProuductList.service;


import com.ecommerce.ProuductList.dto.ProductDTO;
import com.ecommerce.ProuductList.entity.Category;
import com.ecommerce.ProuductList.entity.Product;
import com.ecommerce.ProuductList.mapper.ProductMapper;
import com.ecommerce.ProuductList.repository.CategoryRepository;
import com.ecommerce.ProuductList.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ProductService {


//    we can inject the value of the project repository in it
    private ProductRepository productRepository ;




private CategoryRepository categoryRepository;

public ProductDTO createProduct (ProductDTO productDTO){


    System.out.println(productDTO.getCategoryId());
    System.out.println(productDTO.getDescription());
/**  * name , description , price , category Id
 * first we wanto to check ki jo product hum add kr rhe h auske koi category exist krte h database me ki nahi
 *   example hum clother add kre rhe h toa auske categories exist krne chiyea database me  */
// ere we find that parituclar category exist or not
    Category category=categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new RuntimeException("category did not found "));
//we get the dto in payload and we cannot save the payload in dto so we need to convert into entity
//    dto -->entity
    // after save it will return the entity of the product
  Product product =   ProductMapper.toProductEntity(productDTO,category );
//  to save in the product table we use to save the data in product repo
//    This will return the product entity
     product =productRepository.save(product);
//     in this function  we return the Product Dto se we need to convert it again
//    entity --> dto
  return  ProductMapper.toProductDTO(product);
}


// get all product

    public List<ProductDTO> getallProduct(){

    return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();


    }

//    getProductById
    public ProductDTO getProductByid(Long id ){
 Product pro=   productRepository.findById(id).orElseThrow(()->new RuntimeException("Cannot find a product of particular id"));
 return  ProductMapper.toProductDTO(pro);
    }

//    delete Product By Id

    public String deleteProductById(Long id ){


         productRepository.deleteById(id);
    return "Product Deleted Successfully";

    }

//    Update proudct By id
public ProductDTO updateProduct(Long id , ProductDTO productDTO)
{
    // find the id
    Product product =  productRepository.findById(id).orElseThrow(()->new RuntimeException("Cannot find the product of particular id "));
//    then find the id of the category exist or not
    Category category=categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new RuntimeException("cannot find the category of this particualr id "));

//    Here we set the   new value of the  product
    product.setName(productDTO.getName());
    product.setPrice(productDTO.getPrice());
    product.setDescription(productDTO.getDescription());
    product.setCategory(category);
    productRepository.save(product);
    return ProductMapper.toProductDTO(product);






}


}
