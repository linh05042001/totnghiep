package com.example.totnghiep.model;


import jakarta.persistence.*;

@Entity
@Table(name = "categorys")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private String price;
    @Column(name = "size")
    private String size;
    @Column(name = "image")
    private String image;
    @Column(name = "number")
    private int number;

    public Category(long id, String name, String price, String size, String image,int number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.image = image;
        this.number=number;
    }

    public Category() {

    }

    public long getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}
