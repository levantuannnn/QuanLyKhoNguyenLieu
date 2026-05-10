package com.example.demo.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.*;
import com.example.demo.Service.PhieuNhapService;
import java.util.List;

// Class này dùng để hứng dữ liệu phức hợp từ JSON gửi lên
class PhieuNhapRequest {
    public PhieuNhap phieu;
    public List<ChiTietPhieuNhap> chiTiet;
}

@RestController
@RequestMapping("/api/phieu-nhap")
 
public class PhieuNhapController {
    @Autowired private PhieuNhapService service;

    @PostMapping("/nhap-kho")
    public PhieuNhap nhapKho(@RequestBody PhieuNhapRequest request) {
        return service.thucHienNhapKho(request.phieu, request.chiTiet);
    }
}