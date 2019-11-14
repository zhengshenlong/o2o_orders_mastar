package com.bw.repository;

import com.bw.pojo.ProductCategory;
import com.bw.pojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findAll();

}
