package com.example.totnghiep.Dto;



public class CategoryDto {

    private long id;

    private String name;

    private String price;

    private String size;

    private String image;
    private int number;
    private String type;
    private String details;

    public CategoryDto(long id, String name, String price, String size, String image, int number, String type, String details) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.image = image;
        this.number = number;
        this.type = type;
        this.details = details;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public CategoryDto() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
