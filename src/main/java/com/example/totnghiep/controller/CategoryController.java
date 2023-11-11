package com.example.totnghiep.controller;

import com.example.totnghiep.model.Category;
import com.example.totnghiep.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/get")
    public String getUser(Model model){
        model.addAttribute("category1", categoryService.selectCategory());
        return "sanpham1";
    }
    @GetMapping("/getadminsp")
    public String getAdmin(Model model){
        model.addAttribute("categoryall", categoryService.selectCategory());
        return "admin";
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }


    @PutMapping("/edit")
    public Category editCategory(@RequestParam("id") long id,@RequestBody Category category){
        return  categoryService.editCategory(id,category);
    }


    @DeleteMapping("/delete/{id}")
    public boolean deleteCategory(@PathVariable("id") long id){
        return categoryService.deleteCategory(id);
    }

}
