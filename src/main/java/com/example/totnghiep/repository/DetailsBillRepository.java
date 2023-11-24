package com.example.totnghiep.repository;

import com.example.totnghiep.model.Bill;
import com.example.totnghiep.model.DetailsBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailsBillRepository extends JpaRepository<DetailsBill,Long> {
    @Query("select b from DetailsBill b where b.billid = :billid")
    public List<DetailsBill> getBilld(@Param("billid") Long billid);
}
