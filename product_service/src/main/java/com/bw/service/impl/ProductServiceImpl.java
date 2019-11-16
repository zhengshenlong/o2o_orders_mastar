package com.bw.service.impl;

import com.bw.pojo.ProductCategory;
import com.bw.pojo.ProductInfo;
import com.bw.repository.ProductCategoryRepository;
import com.bw.repository.ProductInfoRepository;
import com.bw.service.ProductService;
import com.bw.util.DataTranferTool;
import com.bw.vo.BuyerProductInfoVO;
import com.bw.vo.FoodVO;
import com.bw.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    @Override
    public Page<ProductInfo> selectProductsByCondition(ProductVo productVO) {
        Specification<ProductInfo> spec = new Specification<ProductInfo>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<ProductInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

                List<Predicate> list = new ArrayList<>();

                if(productVO.getProductName() != null && !productVO.getProductName().equals("")){
                    Predicate p1 = cb.like(root.get("productName"), "%" + productVO.getProductName() + "%");
                    list.add(p1);
                }

                if(productVO.getMinPrice() != null ){
                    Predicate p2 = cb.ge(root.get("productPrice"),productVO.getMinPrice());
                    list.add(p2);
                }

                if(productVO.getMaxPrice() != null ){
                    Predicate p3 = cb.le(root.get("productPrice"),productVO.getMaxPrice());
                    list.add(p3);
                }
                if(productVO.getProductType() != null ){
                    Predicate p4 = cb.equal(root.get("productType"),productVO.getProductType());
                    list.add(p4);
                }


                if(productVO.getPropName() != null && !productVO.getPropName().equals("")){
                    if(productVO.getStartDate() != null ){
                        Predicate p5 = cb.greaterThanOrEqualTo(root.get(productVO.getPropName()),productVO.getStartDate());
                        list.add(p5);
                    }
                    if(productVO.getEndDate() != null ){
                        Predicate p6 = cb.lessThanOrEqualTo(root.get(productVO.getPropName()),productVO.getEndDate());
                        list.add(p6);
                    }
                }


                Predicate[] newArr = list.toArray(new Predicate[list.size()]);

                return cb.and(newArr);
            }
        };


        Page<ProductInfo> page = productInfoRepository.findAll(spec, PageRequest.of(productVO.getPageNum() - 1, productVO.getPageSize()));
        return page;
    }


}
