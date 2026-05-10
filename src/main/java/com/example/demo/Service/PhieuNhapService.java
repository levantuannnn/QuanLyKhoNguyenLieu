package com.example.demo.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Model.*;
import com.example.demo.Jpa.*;

@Service
public class PhieuNhapService {
    @Autowired private PhieuNhapRepository phieuNhapRepo;
    @Autowired private ChiTietPhieuNhapRepository chiTietRepo;
    @Autowired private NguyenLieuService nguyenLieuService;

    public List<PhieuNhap> getAll() { return phieuNhapRepo.findAll(); }

    @Transactional
    public PhieuNhap thucHienNhapKho(PhieuNhap phieu, List<ChiTietPhieuNhap> dsChiTiet) {
        // 1. Lưu phiếu nhập chính
        PhieuNhap savedPhieu = phieuNhapRepo.save(phieu);

        // 2. Lưu danh sách chi tiết và cập nhật số lượng tồn kho
        for (ChiTietPhieuNhap ct : dsChiTiet) {
            ct.setMaPhieuNhap(savedPhieu.getMaPhieuNhap());
            chiTietRepo.save(ct);
            // Cộng thêm vào kho
            nguyenLieuService.updateStock(ct.getMaNguyenLieu(), ct.getSoLuong());
        }
        return savedPhieu;
    }
}