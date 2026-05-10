package com.example.demo.Controler;
 

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.ChiTietPhieuNhap;
import com.example.demo.Service.ChiTietPhieuNhapService;

@RestController
@RequestMapping("/api/chi-tiet-phieu-nhap")
 
public class ChiTietPhieuNhapController {
    @Autowired private ChiTietPhieuNhapService service;

    // Lấy danh sách nguyên liệu của 1 phiếu nhập: /api/chi-tiet-phieu-nhap/phieu/1
    @GetMapping("/phieu/{maPhieu}")
    public List<ChiTietPhieuNhap> getByMaPhieu(@PathVariable Integer maPhieu) {
        return service.getByMaPhieu(maPhieu);
    }
}
