package com.example.totnghiep.service.impl;

import com.example.totnghiep.Dto.LoginDto;
import com.example.totnghiep.Dto.UserDto;
import com.example.totnghiep.model.User;
import com.example.totnghiep.repository.UserRepository;
import com.example.totnghiep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserIMPL implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public String addUser(UserDto userDto) {

        User user= new User(
            userDto.getId(),
            userDto.getEmail(),
            this.passwordEncoder.encode(userDto.getPassword()),
            userDto.getName(),userDto.getAge(),userDto.getAddress(),userDto.getPhone(),userDto.getRole()
        );
        userRepository.save(user);
        return user.getName();
    }

    @Override
    public String loginUer(LoginDto loginDto) {
        String msg = "";
        User user = userRepository.findByEmail(loginDto.getEmail());
        if (user != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user1 = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (user1.isPresent()) {
                    return "Login Success";
                } else {
                    return "Login Failed";
                }
            } else {
                return "password Not Match";
            }
        }else {
            return "Email not exits";
        }
    }

}
