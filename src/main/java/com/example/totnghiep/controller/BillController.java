package com.example.totnghiep.controller;

import com.example.totnghiep.Dto.BIllctDto;
import com.example.totnghiep.Dto.BillDto;
import com.example.totnghiep.model.Category;
import com.example.totnghiep.model.DetailsBill;
import com.example.totnghiep.service.BillService;
import com.example.totnghiep.service.CategoryService;
import com.example.totnghiep.service.DetailsBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("api/v1/bill")
public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private DetailsBillService detailsBillService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/getadminbill")
    public String getAdminBill(Model model){
        model.addAttribute("billall",billService.getAllBill());
        return "admin2";
    }
    @GetMapping("/getbilld/{id}")
    public String getBilld(@PathVariable("id") Long id, Model model){
        List<DetailsBill> kh= detailsBillService.getDetailsBillbyBillid(id);
        List<BIllctDto> kg=new ArrayList<>();
        for(DetailsBill k:kh){
            Category category=categoryService.getCategorybyId(k.getCategoryid());
            BIllctDto bIllctDto=new BIllctDto(category.getImage(), category.getName(), k.getNumbercate(),k.getPaymenttotal()+"");
            kg.add(bIllctDto);
        }
        model.addAttribute("debillall",kg);
        return "chitietbill";
    }
}
