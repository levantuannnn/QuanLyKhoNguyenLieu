package com.example.demo.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.*;
import com.example.demo.Service.PhieuXuatService;

import java.time.LocalDate;
import java.util.List;

 

@RestController
@RequestMapping("/api/phieu-xuat")
 
public class PhieuXuatController {
    @Autowired private PhieuXuatService service; 
    @GetMapping("/xuatkho")
    public byte[] xuatKho(@RequestParam String maphieuxuat,@RequestParam LocalDate ngayxuat,@RequestParam String BophanNhan,@RequestParam String lido,@RequestParam List<String> nl,@RequestParam int sl, @RequestParam String ghichu) throws Exception {  
    	return service.luufile( maphieuxuat,ngayxuat,BophanNhan, lido, nl,sl,ghichu); 
    }
 
 
}