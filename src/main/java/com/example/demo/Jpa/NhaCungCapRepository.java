package com.example.demo.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.NhaCungCap;
 
@Repository
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Integer> {}