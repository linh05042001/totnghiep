package com.example.totnghiep.service;

import com.example.totnghiep.Dto.DetailsBillDto;
import com.example.totnghiep.model.DetailsBill;

import java.util.List;

public interface DetailsBillService {

    public DetailsBill addDb(DetailsBillDto detailsBillDto);
    public List<DetailsBill> getDetailsBillbyBillid(Long billid);
}
