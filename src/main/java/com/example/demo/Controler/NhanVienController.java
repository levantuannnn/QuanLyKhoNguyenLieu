package com.example.demo.Controler;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.NhanVien;
import com.example.demo.Service.NhanVienService;

@RestController
@RequestMapping("/api/nhan-vien")
 
public class NhanVienController {
    @Autowired private NhanVienService service;

    @GetMapping("/nhanvienall")
    public List<NhanVien> getAll() { return service.getAll(); }
   //them nhan vien vao 
    @PostMapping("/luunv")
    public  void save(@RequestBody NhanVien nv) {  service.save(nv); }
    //xoa nhan vien
    @DeleteMapping("/xoanv/{id}")
    public void xoanv(@PathVariable  int id) {
    	  service.delete(id);
    }
}