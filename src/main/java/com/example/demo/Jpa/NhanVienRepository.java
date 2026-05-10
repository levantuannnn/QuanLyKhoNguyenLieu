package com.example.demo.Jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.NhanVien;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {

    List<NhanVien> findByTenNhanVien(String tenNhanVien);

    List<NhanVien> findByTenNhanVienContaining(String tenNhanVien);

    boolean existsByTenNhanVien(String tenNhanVien);
}