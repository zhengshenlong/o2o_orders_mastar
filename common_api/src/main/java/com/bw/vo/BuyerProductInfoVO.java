package com.bw.vo;

import lombok.Data;

import java.util.List;

@Data
public class BuyerProductInfoVO {


    private String name;
    private Integer type;
    private List<FoodVO> foods;

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setFoods(List<FoodVO> foods) {
        this.foods = foods;
    }

    public String getName() {
        return name;
    }

    public Integer getType() {
        return type;
    }

    public List<FoodVO> getFoods() {
        return foods;
    }
}
