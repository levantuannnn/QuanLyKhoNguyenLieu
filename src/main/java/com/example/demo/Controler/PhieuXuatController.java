package com.example.demo.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.*;
import com.example.demo.Service.PhieuXuatService;
import java.util.List;

// Class hứng dữ liệu cho Xuất kho
class PhieuXuatRequest {
    public PhieuXuat phieu;
    public List<ChiTietPhieuXuat> chiTiet;
}

@RestController
@RequestMapping("/api/phieu-xuat")
 
public class PhieuXuatController {
    @Autowired private PhieuXuatService service;

    @PostMapping("/xuat-kho")
    public PhieuXuat xuatKho(@RequestBody PhieuXuatRequest request) {
        return service.thucHienXuatKho(request.phieu, request.chiTiet);
    }
 
}