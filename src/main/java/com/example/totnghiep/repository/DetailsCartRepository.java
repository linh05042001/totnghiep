package com.example.totnghiep.repository;

import com.example.totnghiep.model.DetailsCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailsCartRepository extends JpaRepository<DetailsCart,Long> {
    @Query("select d from DetailsCart d where d.categoryid = :categoryid and d.size = :size and d.cartid= :cartid")
    public DetailsCart getDetailsCartByCategoryid(@Param("categoryid") Long categoryid, @Param("size") String size,@Param("cartid") Long cartid);

    @Query("select d from DetailsCart d where d.cartid= :cartid")
    public List<DetailsCart> getDetailsCartByCartid(@Param("cartid") Long cartid);
}
