package com.example.demo.Controler;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.KiemKe;
import com.example.demo.Service.KiemKeService;

@RestController
@RequestMapping("/api/kiem-ke")
 
public class KiemKeController {
    @Autowired private KiemKeService service;

    @GetMapping
    public List<KiemKe> getAll() { return service.getAll(); }

    @PostMapping
    public KiemKe save(@RequestBody KiemKe kk) {
        return service.save(kk);
    }
 
}