package com.bw.service;

import com.bw.pojo.ProductInfo;
import com.bw.vo.BuyerProductInfoVO;
import com.bw.vo.ProductVo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {


    public List<BuyerProductInfoVO> selectAllProducts();

    public Page<ProductInfo> selectProductsByCondition(ProductVo productVo);
}
