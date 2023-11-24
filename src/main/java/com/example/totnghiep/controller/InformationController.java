package com.example.totnghiep.controller;

import com.example.totnghiep.model.Bill;
import com.example.totnghiep.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("api/v1/thongke")
public class InformationController {

    @Autowired
    private BillService billService;

    @GetMapping("/getthongke")
    public String getAdminBill(){
        return "thongke";
    }
    @RequestMapping ("/thongkedate")
    public String Thongkedate(@RequestParam("ngaybd") String ngaybd ,@RequestParam("ngaykt") String ngaykt,Model model){
        List<Bill> b= billService.getBillbyDate(ngaybd,ngaykt);
        if(b!=null){
            int k=0;
            for (Bill c:b){
                double doubleNumber = Double.parseDouble(c.getPaymenttotal());
                DecimalFormat decimalFormat = new DecimalFormat("#"); // "#.#" để giữ lại một chữ số thập phân nếu có
                String formattedNumber = decimalFormat.format(doubleNumber);
                int intNumber = Integer.parseInt(formattedNumber);
                k=k+intNumber;
            }
            model.addAttribute("thongkedate",k);
        }else {
            model.addAttribute("thongkedate",0);
        }
        return "thongke";
    }
}
