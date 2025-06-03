package com.ecommerce.ProuductList.repository;

import com.ecommerce.ProuductList.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface CategoryRepository extends JpaRepository<Category, Long > {

}
