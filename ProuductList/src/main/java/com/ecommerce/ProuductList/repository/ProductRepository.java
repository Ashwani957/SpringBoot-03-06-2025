package com.ecommerce.ProuductList.repository;

import com.ecommerce.ProuductList.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  ProductRepository  extends JpaRepository<Product, Long > {


}
