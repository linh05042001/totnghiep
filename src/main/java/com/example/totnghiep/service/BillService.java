package com.example.totnghiep.service;

import com.example.totnghiep.Dto.BillDto;
import com.example.totnghiep.model.Bill;

import java.util.List;

public interface BillService {

    public Bill addBill(BillDto billDto);
    public Bill getBillByNote(Long customerid,String time);

    public List<Bill> getAllBill();
    public List<Bill> getBillbyDate(String ngaybd , String ngaykt);
}
