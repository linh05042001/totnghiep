package com.example.totnghiep.service.impl;

import com.example.totnghiep.Dto.LoginDto;
import com.example.totnghiep.Dto.UserDto;
import com.example.totnghiep.model.Cart;
import com.example.totnghiep.model.Customer;
import com.example.totnghiep.model.User;
import com.example.totnghiep.repository.CartRepository;
import com.example.totnghiep.repository.CustomerRepository;
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
    private CartRepository cartRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public String addUser(UserDto userDto) {
        User user1 = userRepository.findByEmail(userDto.getEmail());
        if(user1!=null){
            return "daco";
        }else {
            User user= new User(
                    userDto.getId(),
                    userDto.getEmail(),
                    this.passwordEncoder.encode(userDto.getPassword()),
                    userDto.getRole()
            );

            userRepository.save(user);
            User user2 = userRepository.findByEmail(userDto.getEmail());
            Cart cart=new Cart(
                    user2.getId(),
                    0
            );
            cartRepository.save(cart);
            Customer customer=new Customer(0,null,null,null,null,null,null,user2.getId()
            );
            customerRepository.save(customer);
            return user.getEmail();
        }

    }

    @Override
    public String loginUer(LoginDto loginDto) {

        User user = userRepository.findByEmail(loginDto.getEmail());
        if (user != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user1 = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (user1.isPresent()) {
                    if(user.getRole().equals("ad")) return "admin";
                    else return "redirect:/index/get/"+user.getId();
                } else {
                    return "Login Failed";
                }
            } else {
                return "password Not Match";
            }
        }else {
            return loginDto.getEmail()+'1';
        }
    }

}
