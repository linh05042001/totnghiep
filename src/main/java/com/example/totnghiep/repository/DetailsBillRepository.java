package com.example.totnghiep.repository;

import com.example.totnghiep.model.DetailsBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsBillRepository extends JpaRepository<DetailsBill,Long> {
}
