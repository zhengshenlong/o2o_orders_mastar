package com.bw.service.impl;

import com.bw.pojo.ProductCategory;
import com.bw.pojo.ProductInfo;
import com.bw.repository.ProductCategoryRepository;
import com.bw.repository.ProductInfoRepository;
import com.bw.service.ProductService;
import com.bw.util.DataTranferTool;
import com.bw.vo.BuyerProductInfoVO;
import com.bw.vo.FoodVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductCategoryRepository categoryRepository;


    @Autowired
    private ProductInfoRepository productInfoRepository;



    @Override
    public List<BuyerProductInfoVO> selectAllProducts() {

        List<BuyerProductInfoVO> productVoList = new ArrayList<>();

        List<ProductCategory> catList = categoryRepository.findAll();

        if(catList != null && catList.size()>0){
            for(int i=0; i<catList.size();i++){
                BuyerProductInfoVO buyerProductInfoVO = new BuyerProductInfoVO();

                ProductCategory cat = catList.get(i);//一个类别

                buyerProductInfoVO.setName(cat.getCategoryName());
                buyerProductInfoVO.setType(cat.getCategoryType());
               // buyerProductInfoVO.setFoods();

                List<FoodVO> foodVOS = new ArrayList<>();
                List<ProductInfo> productInfoList = productInfoRepository.findAllByProductStatusAndCategoryType(0, cat.getCategoryType());
                if(productInfoList != null && productInfoList.size()>0){
                    for (ProductInfo productInfo: productInfoList) {
                        //借助工具类 将productInfo转换为FoodVO
                        FoodVO foodVO = DataTranferTool.transferProductInfo(productInfo);
                        foodVOS.add(foodVO);
                    }
                }

                buyerProductInfoVO.setFoods(foodVOS);
                productVoList.add(buyerProductInfoVO);
            }
        }

        return productVoList;
    }


}
