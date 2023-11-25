package com.example.totnghiep.repository;

import com.example.totnghiep.model.Category;
import com.example.totnghiep.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("SELECT c FROM Customer c where c.userid= :userid")
    public Customer getCustomerBy(@Param("userid") long userid);
}
