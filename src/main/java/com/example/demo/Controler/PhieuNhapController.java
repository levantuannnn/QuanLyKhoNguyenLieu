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
    public byte[] download(@RequestParam String nhacungcap,@RequestParam List<String> ng,@RequestParam  int sl,@RequestParam  int dongia) throws Exception { 
    	return service.exportcsv(nhacungcap,ng,sl,dongia); 
    } 
}