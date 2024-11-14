package com.jai.ShopNow.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
// Lombok is library which provides us with different inbuilt methods like getters and setters, ToString
//and other methods which will reduce boiler plate code.

@Data
// Here as I am using data annotation, because It will provide getter and setters automatically.
//why getters and setters? because using them we can avoid constructor to set the data passed through this class
//when using convertToDto method in controller layer.
public class ProductDto {
    private Long id;
    private String name;
    private String descc;
    private String brand;
    private Double price;
    private String category;
    private String releaseDate;
    private Boolean available;
    private Integer quantity;
    private String imageName;
    private String imageType;
    private byte[] imageData;
}
