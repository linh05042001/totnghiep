package com.example.totnghiep.Dto;

public class DetailsCartDto {

    private long id;

    private long cartid;
    private long categoryid;
    private String size;
    private int number;

    public DetailsCartDto(long id, long cartid, long categoryid, String size,int number) {
        this.id = id;
        this.cartid = cartid;
        this.categoryid = categoryid;
        this.size=size;
        this.number = number;
    }

    public DetailsCartDto() {
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCartid() {
        return cartid;
    }

    public void setCartid(long cartid) {
        this.cartid = cartid;
    }

    public long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(long categoryid) {
        this.categoryid = categoryid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}


