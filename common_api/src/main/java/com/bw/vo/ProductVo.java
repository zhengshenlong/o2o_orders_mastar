package com.bw.vo;

import java.math.BigDecimal;
import java.util.Date;

public class ProductVo {

    private  String  productName;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Integer  productType;
    private String  propName;
    private Date startDate;
    private Date  endDate;

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getPropName() {
        return propName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }


    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public Integer getProductType() {
        return productType;
    }



    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    private Integer  pageNum;
    private Integer  pageSize;

}
