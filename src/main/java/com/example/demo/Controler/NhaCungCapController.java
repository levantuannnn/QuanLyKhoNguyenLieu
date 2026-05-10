package com.example.demo.Controler;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.NhaCungCap;
import com.example.demo.Service.NhaCungCapService;

@RestController
@RequestMapping("/api/nha-cung-cap")
 
public class NhaCungCapController {
    @Autowired private NhaCungCapService service;

    @GetMapping("/hienncc")
    public List<NhaCungCap> getAll() { return service.getAll(); }
    
    @PostMapping
    public NhaCungCap save(@RequestBody NhaCungCap ncc) { return service.save(ncc); }
    @DeleteMapping("/xoancc/{id}")
    public void xoanhacungcap(@PathVariable int id) {
    	 service.delete(id);
    }
    @PostMapping("/themncc")
    public void themncc(@RequestBody NhaCungCap sc) {
    	 service.save(sc);
    }
    @PutMapping("/xuancc/{id}")
    public void suancc(@PathVariable int id,@RequestBody NhaCungCap nc) {
    	 service.suancc(id, nc);
    }
}