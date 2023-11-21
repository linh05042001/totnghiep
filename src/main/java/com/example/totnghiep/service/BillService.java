package com.example.totnghiep.service;

import com.example.totnghiep.Dto.BillDto;
import com.example.totnghiep.model.Bill;

public interface BillService {

    public Bill addBill(BillDto billDto);
    public Bill getBillByNote(Long customerid,String time);
}
