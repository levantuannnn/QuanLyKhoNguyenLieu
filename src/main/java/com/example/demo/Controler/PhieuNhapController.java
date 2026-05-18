package com.example.demo.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.*;
import com.example.demo.Service.PhieuNhapService;
import java.util.List;

 
@RestController
@RequestMapping("/api/phieu-nhap")
 
public class PhieuNhapController {
    @Autowired private PhieuNhapService service;

    @GetMapping("/download")
    public byte[] download(@RequestParam String maphieunhap,   @RequestParam String nhacungcap,@RequestParam List<String> ng,@RequestParam  int sl,@RequestParam  int dongia, @RequestParam String ghichu) throws Exception { 
    	return service.exportcsv(maphieunhap,nhacungcap,ng,sl,dongia,ghichu); 
    } 
}