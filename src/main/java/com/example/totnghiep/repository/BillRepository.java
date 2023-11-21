package com.example.totnghiep.repository;

import com.example.totnghiep.model.Bill;
import com.example.totnghiep.model.DetailsCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {
    @Query("select b from Bill b where b.customerid = :customerid and b.note = :note")
    public Bill getBillByNote(@Param("customerid") Long customerid, @Param("note") String note);
}
