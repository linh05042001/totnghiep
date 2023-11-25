package com.example.totnghiep.service;

import com.example.totnghiep.Dto.CustomerDto;
import com.example.totnghiep.model.Customer;

public interface CustomerService {

    public Customer getCutomerByuid(long id);

    public Customer editCustomer(long id,CustomerDto customerDto);

    public Customer addCustomer(long id);
}
