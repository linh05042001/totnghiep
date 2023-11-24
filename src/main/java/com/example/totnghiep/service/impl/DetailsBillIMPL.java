package com.example.totnghiep.service.impl;

import com.example.totnghiep.Dto.DetailsBillDto;
import com.example.totnghiep.model.Category;
import com.example.totnghiep.model.DetailsBill;
import com.example.totnghiep.repository.DetailsBillRepository;
import com.example.totnghiep.service.DetailsBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsBillIMPL implements DetailsBillService {

    @Autowired
    private DetailsBillRepository detailsBillRepository;
    @Override
    public DetailsBill addDb(DetailsBillDto detailsBillDto) {
        if(detailsBillDto != null){
            DetailsBill detailsBill=new DetailsBill(
                    detailsBillDto.getId(),
                    detailsBillDto.getCategoryid(),
                    detailsBillDto.getBillid(),
                    detailsBillDto.getPaymenttotal(),
                    detailsBillDto.getNumbercate()
            );
            return detailsBillRepository.save(detailsBill);
        }
        return null;
    }

    @Override
    public List<DetailsBill> getDetailsBillbyBillid(Long billid) {
        return detailsBillRepository.getBilld(billid);
    }
}
