package com.example.totnghiep.controller;

import com.example.totnghiep.Dto.CategoryDto;
import com.example.totnghiep.Dto.CustomerDto;
import com.example.totnghiep.Dto.DetailsCartDto;
import com.example.totnghiep.service.CategoryService;
import com.example.totnghiep.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @ModelAttribute("customer")
    public CustomerDto customerDto(){
        return new CustomerDto();
    }
    @GetMapping("/get/{id}")
    public String getCus(@PathVariable("id") long id, Model model){
        model.addAttribute("customer", customerService.getCutomerByuid(id));
        return "thongtin";
    }
    @GetMapping("/getedit/{id}")
    public String geteditCus(@PathVariable("id") long id, Model model){
        model.addAttribute("customer", customerService.getCutomerByuid(id));
        return "addthongtin";
    }
    @PostMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") long id, @ModelAttribute("customer")CustomerDto customerDto){
        customerService.editCustomer(id,customerDto);
        return "redirect:/api/v1/customer/get/"+id;
    }
}
