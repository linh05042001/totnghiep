package com.example.totnghiep.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detailsbill")
public class DetailsBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(name="categoryId")
    private long categoryid;

    @Column(name = "billId")
    private long billid;

    @Column(name = "paymentTotal")
    private long paymenttotal;

    @Column(name = "numberCate")
    private int numbercate;

    public DetailsBill(long id, long categoryid, long billid, long paymenttotal, int numbercate) {
        this.id = id;
        this.categoryid = categoryid;
        this.billid = billid;
        this.paymenttotal = paymenttotal;
        this.numbercate = numbercate;
    }

    public DetailsBill() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(long categoryid) {
        this.categoryid = categoryid;
    }

    public long getBillid() {
        return billid;
    }

    public void setBillid(long billid) {
        this.billid = billid;
    }

    public long getPaymenttotal() {
        return paymenttotal;
    }

    public void setPaymenttotal(long paymenttotal) {
        this.paymenttotal = paymenttotal;
    }

    public int getNumbercate() {
        return numbercate;
    }

    public void setNumbercate(int numbercate) {
        this.numbercate = numbercate;
    }
}
