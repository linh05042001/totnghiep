package com.example.totnghiep.service;

import com.example.totnghiep.Dto.LoginDto;
import com.example.totnghiep.Dto.UserDto;

public interface UserService {
    String addUser(UserDto userDto);
    String loginUer(LoginDto loginDto);
}
