package com.example.totnghiep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/get/{id}")
    public String getUser(@PathVariable("id") long id,Model model){
        model.addAttribute("idname",id);
        return "index";
    }
}
