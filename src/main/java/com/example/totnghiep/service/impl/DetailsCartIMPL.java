package com.example.totnghiep.service.impl;

import com.example.totnghiep.Dto.DetailsCartDto;
import com.example.totnghiep.model.Category;
import com.example.totnghiep.model.DetailsCart;
import com.example.totnghiep.repository.DetailsCartRepository;
import com.example.totnghiep.service.DetailsCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsCartIMPL implements DetailsCartService {


    @Autowired
    private DetailsCartRepository detailsCartRepository;
    @Override
    public DetailsCart add(DetailsCartDto detailsCartDto) {

        if(detailsCartDto != null){
            DetailsCart detailsCart1= detailsCartRepository.getDetailsCartByCategoryid(detailsCartDto.getCategoryid(), detailsCartDto.getSize(),detailsCartDto.getCartid());
            if(detailsCart1!=null){
                detailsCart1.setNumber(detailsCart1.getNumber()+detailsCartDto.getNumber());
                return detailsCartRepository.save(detailsCart1);
            }else{
                DetailsCart detailsCart=new DetailsCart(
                        detailsCartDto.getId(),
                        detailsCartDto.getCartid(),
                        detailsCartDto.getCategoryid(),
                        detailsCartDto.getSize(),
                        detailsCartDto.getNumber()
                );
                return detailsCartRepository.save(detailsCart);
            }

        }
        return null;

    }

    @Override
    public List<DetailsCart> getbyCart(Long cartid) {
        return detailsCartRepository.getDetailsCartByCartid(cartid);
    }
}
