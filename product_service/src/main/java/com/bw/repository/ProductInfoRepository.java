package com.bw.repository;

import com.bw.pojo.ProductCategory;
import com.bw.pojo.ProductInfo;
import com.bw.vo.ProductVo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>, JpaSpecificationExecutor<ProductInfo> {



    List<ProductInfo> findAllByProductStatusAndCategoryType(Integer status, Integer type);


    Page<ProductVo> findAll(Integer pageNum,Integer pageSize);
}
