package com.example.totnghiep.service.impl;

import com.example.totnghiep.Dto.CustomerDto;
import com.example.totnghiep.model.Category;
import com.example.totnghiep.model.Customer;
import com.example.totnghiep.repository.CategoryRepository;
import com.example.totnghiep.repository.CustomerRepository;
import com.example.totnghiep.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerIMPL implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer getCutomerByuid(long userid) {
        return customerRepository.getCustomerBy(userid);
    }

    @Override
    public Customer editCustomer(long id, CustomerDto customerDto) {
        if(customerDto!=null){
            Customer us=customerRepository.getCustomerBy(id);
            if(us!=null){
                us.setName(customerDto.getName());
                us.setAddress(customerDto.getAddress());
                us.setEmail(customerDto.getEmail());
                us.setSex(customerDto.getSex());
                us.setTel(customerDto.getTel());
                us.setNgaysinh(customerDto.getNgaysinh());
                return customerRepository.save(us);
            }
        }
        return null;
    }

    @Override
    public Customer addCustomer(long id) {

            Customer customer=new Customer(0,null,null,null,null,null,null,id
            );
            return customerRepository.save(customer);

    }
}
