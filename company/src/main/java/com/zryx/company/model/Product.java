package com.zryx.company.model;

import java.math.BigDecimal;

public class Product {
    private int productId;
    private String serialNumber;
    private String name;
    private String brand;
    private String model;
    private BigDecimal price;
    private String picture;
    private String  description;

    public Product(int productId, String serialNumber, String name, String brand, String model, BigDecimal price, String picture, String description) {
        this.productId = productId;
        this.serialNumber = serialNumber;
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.picture = picture;
        this.description = description;
    }

    public int getProductId() {
        return productId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getPicture() {
        return picture;
    }

    public String getDescription() {
        return description;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", serialNumber='" + serialNumber + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", price='" + price +
                ", picture='" + picture + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
