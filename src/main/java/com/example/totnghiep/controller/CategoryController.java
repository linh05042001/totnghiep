package com.example.totnghiep.controller;

import com.example.totnghiep.model.Category;
import com.example.totnghiep.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/get")
    public List<Category> getUser(){
        return categoryService.selectCategory();
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
