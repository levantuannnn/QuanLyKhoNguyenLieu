package com.example.demo.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.BaoCaoHuHong;

@Repository
public interface BaoCaoHuHongRepository extends JpaRepository<BaoCaoHuHong, Integer> {}