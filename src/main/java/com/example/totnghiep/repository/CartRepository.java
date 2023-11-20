package com.example.totnghiep.repository;

import com.example.totnghiep.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    @Query("select c from Cart c where c.customerid = :customerid")
    public Cart searchCartByCustomerid(@Param("customerid") Long customerid);
}
