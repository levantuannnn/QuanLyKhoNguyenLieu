package com.example.demo.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Jpa.NguyenLieuRepository;
import com.example.demo.Model.NguyenLieu;
import com.example.demo.Service.NguyenLieuService;

@RestController
@RequestMapping("/api/nguyen-lieu")
public class NguyenLieuController {
	@Autowired
    private  NguyenLieuService service;
    @Autowired
    private  NguyenLieuRepository jpass;
 
    @GetMapping
    public ResponseEntity<List<NguyenLieu>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
 
    @GetMapping("/serach")
    public ResponseEntity<?> getById(@RequestParam String name) {
        NguyenLieu nl = jpass.findByTenNguyenLieu(name).orElse(null);
        if (nl == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nl);
    } 
    @PostMapping
    public ResponseEntity<NguyenLieu> create(@RequestBody NguyenLieu nl) {
        return ResponseEntity.ok(service.save(nl));
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody NguyenLieu nl) {
        return service.getById(id) == null
            ? ResponseEntity.notFound().build()
            : ResponseEntity.ok(service.save(nl));
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        NguyenLieu existing = service.getById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        } 
        service.delete(id);	
        return ResponseEntity.ok("Xóa thành công");
    }
}