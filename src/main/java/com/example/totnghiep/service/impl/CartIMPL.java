package com.example.totnghiep.service.impl;

import com.example.totnghiep.Dto.DetailsCartDto;
import com.example.totnghiep.model.Cart;
import com.example.totnghiep.model.Category;
import com.example.totnghiep.model.DetailsCart;
import com.example.totnghiep.repository.CartRepository;
import com.example.totnghiep.repository.DetailsCartRepository;
import com.example.totnghiep.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartIMPL implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart getCartsByCustomerId(Long customerid) {
        return cartRepository.searchCartByCustomerid(customerid);
    }

    @Override
    public Cart getCartById(Long cartid) {
        Cart us=cartRepository.getById(cartid);
        if (us!=null) {
            return us;
        }
        return null;
    }
}
