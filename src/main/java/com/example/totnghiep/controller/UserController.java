package com.example.totnghiep.controller;


import com.example.totnghiep.Dto.LoginDto;
import com.example.totnghiep.Dto.UserDto;
import com.example.totnghiep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@CrossOrigin
@Controller
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @ModelAttribute("logindto")
    public LoginDto loginDto(){
        return new LoginDto();
    }
    @GetMapping("/login1")
    public String showLoginForm(){
        return "login";
    }
    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDto userDto)
    {
        String id = userService.addUser(userDto);
        return id;
    }
    @PostMapping(path = "/login")
    public String loginUser(@ModelAttribute("logindto") LoginDto loginDTO)
    {
        return userService.loginUer(loginDTO);
    }

}
