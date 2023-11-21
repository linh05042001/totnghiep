package com.example.totnghiep.Dto;

public class PaymentDto {
    private String paymenttotal;


    private long cartid;


    private String name;

    private String address;

    private String tel;

    public PaymentDto(String paymenttotal, long cartid, String name, String address, String tel) {
        this.paymenttotal = paymenttotal;
        this.cartid = cartid;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    public PaymentDto() {
    }

    public String  getPaymenttotal() {
        return paymenttotal;
    }

    public void setPaymenttotal(String paymenttotal) {
        this.paymenttotal = paymenttotal;
    }

    public long getCartid() {
        return cartid;
    }

    public void setCartid(long cartid) {
        this.cartid = cartid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
