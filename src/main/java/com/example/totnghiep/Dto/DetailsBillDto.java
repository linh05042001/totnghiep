package com.example.totnghiep.Dto;



public class DetailsBillDto {

    private long id;


    private long categoryid;


    private long billid;


    private long paymenttotal;


    private int numbercate;

    public DetailsBillDto(long id, long categoryid, long billid, long paymenttotal, int numbercate) {
        this.id = id;
        this.categoryid = categoryid;
        this.billid = billid;
        this.paymenttotal = paymenttotal;
        this.numbercate = numbercate;
    }

    public DetailsBillDto() {
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
