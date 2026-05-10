package com.example.demo.Service;

 

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.ChiTietPhieuNhap;
import com.example.demo.Jpa.ChiTietPhieuNhapRepository;

@Service
public class ChiTietPhieuNhapService {
    @Autowired
    private ChiTietPhieuNhapRepository repo;

    public List<ChiTietPhieuNhap> getByMaPhieu(Integer maPhieu) {
        return repo.findByMaPhieuNhap(maPhieu);
    }

    public ChiTietPhieuNhap save(ChiTietPhieuNhap ct) {
        return repo.save(ct);
    }
}