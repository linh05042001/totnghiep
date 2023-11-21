package com.example.totnghiep.Dto;



public class BillDto {
    private long id;


    private String paymentdate;


    private long customerid;


    private String note;


    private String paymenttype;
    private String name;

    private String address;

    private String tel;
    private String paymenttotal;

    public BillDto(long id, String paymentdate, long customerid, String note, String paymenttype, String name, String address, String tel, String paymenttotal) {
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

    public String getPaymenttotal() {
        return paymenttotal;
    }

    public void setPaymenttotal(String paymenttotal) {
        this.paymenttotal = paymenttotal;
    }

    public BillDto() {
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
}
