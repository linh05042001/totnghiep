package com.example.totnghiep.controller;

import com.example.totnghiep.Dto.CategoryDto;
import com.example.totnghiep.Dto.DetailsCartDto;
import com.example.totnghiep.Dto.LoginDto;
import com.example.totnghiep.model.Category;
import com.example.totnghiep.service.CartService;
import com.example.totnghiep.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    @Autowired
    private CartService cartService;
    @ModelAttribute("categorydto")
    public CategoryDto categoryDto(){
        return new CategoryDto();
    }
    @ModelAttribute("categoryedit")
    public CategoryDto categoryEdit(){
        return new CategoryDto();
    }
    @ModelAttribute("detailscart")
    public DetailsCartDto detailsCartDto(){
        return new DetailsCartDto();
    }
    @GetMapping("/get/{id}")
    public String getCate1(@PathVariable("id") long id,Model model){
        model.addAttribute("idname",id);
        model.addAttribute("category1", categoryService.SelectType("mot"));
        return "sanpham1";
    }
    @GetMapping("/get2/{id}")
    public String getCate2(@PathVariable("id") long id,Model model){
        model.addAttribute("idname",id);
        model.addAttribute("category1", categoryService.SelectType("hai"));
        return "sanpham2";
    }
    @GetMapping("/getadd")
    public String getAdd(){
        return "addcategory";
    }
    @GetMapping("/getadminsp")
    public String getAdmin(Model model){
        model.addAttribute("categoryall", categoryService.selectCategory());
        return "admin";
    }
    @GetMapping("/getedit/{id}")
    public String getEdit(@PathVariable("id") long id,Model model){
        model.addAttribute("categoryedit", categoryService.getCategorybyId(id));
        return "editcategory";
    }
    @PostMapping("/add")
    public String addCategory(@ModelAttribute("categorydto") CategoryDto categoryDto){
        categoryService.addCategory(categoryDto);
        return "redirect:/api/v1/category/getadminsp";
    }


    @PostMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") long id,@ModelAttribute("categoryedit") CategoryDto categoryDto){
        categoryService.editCategory(id,categoryDto);
        return "redirect:/api/v1/category/getadminsp";
    }


    @RequestMapping( "/delete/{id}")
    public String deleteCategory(@PathVariable("id") long id){
        categoryService.deleteCategory(id);
        return "redirect:/api/v1/category/getadminsp";
    }

    @GetMapping("/getchitiet/{id}/{idname}")
    public String getChitiet(@PathVariable("id") long id,Model model,@PathVariable("idname") long idname){
        model.addAttribute("categorychitiet", categoryService.getCategorybyId(id));
        model.addAttribute("idname", idname);
        model.addAttribute("idcart",cartService.getCartsByCustomerId(idname));
        return "chitiet";
    }
    @RequestMapping ("/seach/{id}")
    public String Seach(@PathVariable("id") long id, @Param("key") String key, Model model){
        model.addAttribute("idname",id);
        model.addAttribute("category1", categoryService.seach(key));
        return "sanpham1";
    }
    @RequestMapping ("/min/{id}")
    public String Min(@PathVariable("id") long id,@RequestParam("sapxep") String a, Model model){
        model.addAttribute("idname",id);
        if(a.equals("b")){
            model.addAttribute("category1", categoryService.Mindan("mot"));
        } else if (a.equals("c")){
            model.addAttribute("category1", categoryService.Maxdan("mot"));
        }

        return "sanpham1";
    }
    @RequestMapping ("/min2/{id}")
    public String Min2(@PathVariable("id") long id,@RequestParam("sapxep") String a, Model model){
        model.addAttribute("idname",id);
        if(a.equals("b")){
            model.addAttribute("category1", categoryService.Mindan("hai"));
        } else if (a.equals("c")){
            model.addAttribute("category1", categoryService.Mindan("hai"));
        }

        return "sanpham2";
    }
}
