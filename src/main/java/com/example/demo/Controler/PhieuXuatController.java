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
    public byte[] xuatKho(@RequestParam LocalDate ngayxuat,@RequestParam String lido,@RequestParam List<String> nl) throws Exception {  
    	return service.luufile( ngayxuat, lido, nl); 
    }
 
 
}