package com.example.totnghiep.Dto;

public class CartAllDto {
    private long id;
    private long cartid;
    private long categoryid;

    private String name;

    private String image;

    private String size;
    private int number;

    private String totalprice;
     private String total;

    public CartAllDto() {
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

    public String getName() {
        return name;
    }

    public CartAllDto(long id, long cartid, long categoryid, String name, String image, String size, int number, String totalprice, String total) {
        this.id = id;
        this.cartid = cartid;
        this.categoryid = categoryid;
        this.name = name;
        this.image = image;
        this.size = size;
        this.number = number;
        this.totalprice = totalprice;
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
