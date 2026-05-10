package com.example.demo.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.NguyenLieu;

@Repository
public interface NguyenLieuRepository extends JpaRepository<NguyenLieu, Integer> {}