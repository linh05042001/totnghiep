package com.example.totnghiep.controller;


import com.example.totnghiep.Dto.CartAllDto;
import com.example.totnghiep.Dto.CartDto;
import com.example.totnghiep.Dto.CategoryDto;
import com.example.totnghiep.Dto.DetailsCartDto;
import com.example.totnghiep.model.Cart;
import com.example.totnghiep.model.Category;
import com.example.totnghiep.model.DetailsCart;
import com.example.totnghiep.service.CartService;
import com.example.totnghiep.service.CategoryService;
import com.example.totnghiep.service.DetailsCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("api/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private DetailsCartService detailsCartService;
    @Autowired
    private CategoryService categoryService;
    @ModelAttribute("detailscart")
    public DetailsCartDto detailsCartDto(){
        return new DetailsCartDto();
    }
//    @ModelAttribute("addcart")
//    public CartDto cartDto(){
//        return new CartDto();
//    }
    @PostMapping("/adddc")
    public String addCategory(@ModelAttribute("detailscart") DetailsCartDto detailsCartDto){
        detailsCartService.add(detailsCartDto);
        return "redirect:/api/v1/cart/getcart/"+detailsCartDto.getCartid();
    }
    @GetMapping("/getcart/{id}")
    public String getEdit(@PathVariable("id") long id, Model model){
        cartService.addTotalCart(id);
        model.addAttribute("cart", cartService.getCartById(id));
        List<DetailsCart> dt=detailsCartService.getbyCart(id);
        List<CartAllDto> call=new ArrayList<>();
        for (DetailsCart s:dt){
            Category category= categoryService.getCategorybyId(s.getCategoryid());
            CartAllDto ct = new CartAllDto(
                    s.getId(),
                    s.getCartid(),
                    category.getId(),
                    category.getName(),
                    category.getImage(),
                    s.getSize(),
                    s.getNumber(),
                    (s.getNumber()*Integer.parseInt(category.getPrice()))+"",
                    category.getPrice()

            );
            call.add(ct);
        }
        model.addAttribute("detailscartall",call);
        return "cart";
    }
    @GetMapping("/getcartall/{id}")
    public String getCart(@PathVariable("id") long id, Model model){
        Cart cart = cartService.getCartsByCustomerId(id);
        cartService.addTotalCart(cart.getId());
        model.addAttribute("cart", cartService.getCartById(cart.getId()));
        List<DetailsCart> dt=detailsCartService.getbyCart(cart.getId());
        List<CartAllDto> call=new ArrayList<>();
        for (DetailsCart s:dt){
            Category category= categoryService.getCategorybyId(s.getCategoryid());
            CartAllDto ct = new CartAllDto(
                    s.getId(),
                    s.getCartid(),
                    category.getId(),
                    category.getName(),
                    category.getImage(),
                    s.getSize(),
                    s.getNumber(),
                    (s.getNumber()*Integer.parseInt(category.getPrice()))+"",
                    category.getPrice()

            );
            call.add(ct);
        }
        model.addAttribute("detailscartall",call);
        return "cart";
    }
    @GetMapping("/delete/{id}/{cartidd}")
    public String delete(@PathVariable("id") long id,@PathVariable("cartidd") long cartidd, Model model){
        detailsCartService.deleteById(id);
        return "redirect:/api/v1/cart/getcart/"+cartidd;
    }
}
