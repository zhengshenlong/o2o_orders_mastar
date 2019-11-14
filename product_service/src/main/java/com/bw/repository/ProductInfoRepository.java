package com.bw.repository;

import com.bw.pojo.ProductCategory;
import com.bw.pojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>{



    List<ProductInfo> findAllByProductStatusAndCategoryType(Integer status, Integer type);



}
