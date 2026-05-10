package com.example.demo.Controler;

 

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.ChiTietPhieuXuat;
import com.example.demo.Service.ChiTietPhieuXuatService;

@RestController
@RequestMapping("/api/chi-tiet-phieu-xuat") 
public class ChiTietPhieuXuatController {
    @Autowired private ChiTietPhieuXuatService service;

    // Lấy danh sách nguyên liệu của 1 phiếu xuất: /api/chi-tiet-phieu-xuat/phieu/1
    @GetMapping("/phieu/{maPhieu}")
    public List<ChiTietPhieuXuat> getByMaPhieu(@PathVariable Integer maPhieu) {
        return service.getByMaPhieu(maPhieu);
    }
    
    
}