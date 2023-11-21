package com.example.totnghiep.service;

import com.example.totnghiep.Dto.DetailsCartDto;
import com.example.totnghiep.model.DetailsCart;

import java.util.List;

public interface DetailsCartService {
    public DetailsCart add(DetailsCartDto detailsCartDto);
    public List<DetailsCart> getbyCart(Long cartid);

    public boolean deleteById(long id);

    public boolean deleteall(Long cartid);
}
