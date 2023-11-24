package com.example.totnghiep.service.impl;

import com.example.totnghiep.Dto.BillDto;
import com.example.totnghiep.model.Bill;
import com.example.totnghiep.model.Category;
import com.example.totnghiep.repository.BillRepository;
import com.example.totnghiep.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillIMPL implements BillService {
    @Autowired
    private BillRepository billRepository;
    @Override
    public Bill addBill(BillDto billDto) {
        if(billDto != null){
            Bill bill=new Bill(
                    billDto.getId(),
                    billDto.getPaymentdate(),
                    billDto.getCustomerid(),
                    billDto.getNote(),
                    billDto.getPaymenttype(),
                    billDto.getName(),
                    billDto.getAddress(),
                    billDto.getTel(),
                    billDto.getPaymenttotal()
            );
            return billRepository.save(bill);
        }
        return null;
    }

    @Override
    public Bill getBillByNote(Long customerid, String note) {
        return billRepository.getBillByNote(customerid,note);
    }

    @Override
    public List<Bill> getAllBill() {
        return billRepository.findAll();
    }

    @Override
    public List<Bill> getBillbyDate(String ngaybd, String ngaykt) {
        return billRepository.getBillByDate(ngaybd,ngaykt);
    }


}
