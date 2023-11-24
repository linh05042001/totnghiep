package com.example.totnghiep.repository;

import com.example.totnghiep.model.Cart;
import com.example.totnghiep.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("SELECT c FROM Category c WHERE c.name LIKE %?1%")
    public List<Category> search(String keyword);
    @Query("SELECT c FROM Category c where c.type= :type ORDER BY  c.price ASC ")
    public List<Category> Mindan(@Param("type") String type);
    @Query("SELECT c FROM Category c WHERE c.type= :type ORDER BY c.price desc ")
    public List<Category> Maxdan(@Param("type") String type);
    @Query("SELECT c FROM Category c WHERE c.type = :type ")
    public List<Category> SelectType(@Param("type") String  type);




}
