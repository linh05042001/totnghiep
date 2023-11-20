package com.example.totnghiep.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detailscart")
public class DetailsCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(name = "cartid")
    private long cartid;

    @Column(name = "categoryid")
    private long categoryid;

    @Column(name = "size")
    private String size;
    @Column(name = "number")
    private int number;

    public DetailsCart(long id, long cartid, long categoryid,String size, int number) {
        this.id = id;
        this.cartid = cartid;
        this.categoryid = categoryid;
        this.size=size;
        this.number = number;
    }

    public DetailsCart() {
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
