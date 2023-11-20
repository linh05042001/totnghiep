package com.example.totnghiep.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(name = "customerId")
    private long customerid;

    @Column(name = "pricetotal")
    private float pricetotal;

    public Cart(long id, long customerid, float pricetotal) {
        this.id = id;
        this.customerid = customerid;
        this.pricetotal = pricetotal;
    }

    public Cart() {
    }

    public Cart(long customerid, float pricetotal) {
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
