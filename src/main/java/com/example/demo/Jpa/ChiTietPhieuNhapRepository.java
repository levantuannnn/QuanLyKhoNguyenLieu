package com.example.demo.Jpa;

 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.ChiTietPhieuNhap;

@Repository 
public interface ChiTietPhieuNhapRepository extends JpaRepository<ChiTietPhieuNhap, ChiTietPhieuNhap> {
    // Kiểu ID ở đây là ChiTietPhieuNhap vì bạn dùng @IdClass là chính nó
	List<ChiTietPhieuNhap> findByMaPhieuNhap(Integer maPhieuNhap);
}