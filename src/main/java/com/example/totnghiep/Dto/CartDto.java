package com.example.totnghiep.Dto;

public class CartDto {

    private long id;

    private long customerid;
    private float pricetotal;

    public CartDto() {
    }

    public CartDto(long id, long customerid, float pricetotal) {
        this.id = id;
        this.customerid = customerid;
        this.pricetotal = pricetotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    public float getPricetotal() {
        return pricetotal;
    }

    public void setPricetotal(float pricetotal) {
        this.pricetotal = pricetotal;
    }
}
