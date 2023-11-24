package com.example.totnghiep.Dto;

public class BIllctDto {
    private String image;
    private String name;

    private int number;

    private String price;

    public BIllctDto(String image, String name, int number, String price) {
        this.image = image;
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public BIllctDto() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
