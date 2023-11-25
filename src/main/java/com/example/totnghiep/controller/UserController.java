package com.example.totnghiep.controller;


import com.example.totnghiep.Dto.LoginDto;
import com.example.totnghiep.Dto.UserDto;
import com.example.totnghiep.service.CustomerService;
import com.example.totnghiep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@CrossOrigin
@Controller
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    @ModelAttribute("logindto")
    public LoginDto loginDto(){
        return new LoginDto();
    }
    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }
    @GetMapping("/login1")
    public String showLoginForm(){
        return "login";
    }
    @GetMapping("/dangky")
    public String dangKyForm(){
        return "dangky";
    }
    @PostMapping(path = "/save")
    public String saveUser(@ModelAttribute("userdto") UserDto userDto)
    {

        String ad = userService.addUser(userDto);
        if(ad.equals("daco")){
            return "redirect:/api/v1/user/dangky?emailwrong";
        }else{
            return "login";
        }

    }
    @PostMapping(path = "/login")
    public String loginUser(@ModelAttribute("logindto") LoginDto loginDTO)
    {
        return userService.loginUer(loginDTO);
    }

}
