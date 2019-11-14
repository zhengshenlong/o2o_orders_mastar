package com.bw.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FoodVO {

    private String id;
    private String name;
    private BigDecimal price;
    private String description;
    private String icon;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
