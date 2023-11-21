package com.example.totnghiep.service;

import com.example.totnghiep.Dto.DetailsCartDto;
import com.example.totnghiep.model.Cart;
import com.example.totnghiep.model.DetailsCart;

import java.util.List;

public interface CartService {

    public Cart getCartsByCustomerId(Long customerid) ;
    public Cart getCartById(Long cartid);
    public Cart addTotalCart(Long cartid);
 }
