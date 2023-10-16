package com.example.totnghiep.controller;


import com.example.totnghiep.Dto.LoginDto;
import com.example.totnghiep.Dto.UserDto;
import com.example.totnghiep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDto userDto)
    {
        String id = userService.addUser(userDto);
        return id;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDTO)
    {
        return ResponseEntity.ok(userService.loginUer(loginDTO));
    }
}
