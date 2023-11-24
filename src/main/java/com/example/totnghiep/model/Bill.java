package com.example.totnghiep.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(name = "paymentDate")
    private String paymentdate;

    @Column(name = "customerId")
    private long customerid;

    @Column(name="note")
    private String note;

    @Column(name="paymentType")
    private String paymenttype;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name="tel")
    private String tel;
    @Column(name="paymenttotal")
    private String paymenttotal;

    public Bill(long id, String paymentdate, long customerid, String note, String paymenttype, String name, String address, String tel, String paymenttotal) {
        this.id = id;
        this.paymentdate = paymentdate;
        this.customerid = customerid;
        this.note = note;
        this.paymenttype = paymenttype;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.paymenttotal = paymenttotal;
    }

    public Bill() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(String paymentdate) {
        this.paymentdate = paymentdate;
    }

    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
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

    public String getPaymenttotal() {
        return paymenttotal;
    }

    public void setPaymenttotal(String paymenttotal) {
        this.paymenttotal = paymenttotal;
    }
}
