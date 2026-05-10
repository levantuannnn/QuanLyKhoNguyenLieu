package com.example.demo.Service;
 

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Model.*;
import com.example.demo.Jpa.*;

@Service
public class PhieuXuatService {
    @Autowired private PhieuXuatRepository phieuXuatRepo;
    @Autowired private ChiTietPhieuXuatRepository chiTietRepo;
    @Autowired private NguyenLieuService nguyenLieuService;
 // Trong file NguyenLieuService.java
  
    @Transactional
    public PhieuXuat thucHienXuatKho(PhieuXuat phieu, List<ChiTietPhieuXuat> dsChiTiet) {
        PhieuXuat savedPhieu = phieuXuatRepo.save(phieu);
        for (ChiTietPhieuXuat ct : dsChiTiet) {
            ct.setMaPhieuXuat(savedPhieu.getMaPhieuXuat());
            chiTietRepo.save(ct);
            // Trừ đi trong kho (truyền số âm)
            nguyenLieuService.updateStock(ct.getMaNguyenLieu(), -ct.getSoLuong());
        }
        return savedPhieu;
    }
    public List<PhieuXuat> hienthiten(String  ten){
    	return   phieuXuatRepo.exitTen(ten);
    	 
    }
    
}