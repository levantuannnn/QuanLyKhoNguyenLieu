package com.example.demo.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.BaoCaoHuHong;
import com.example.demo.Service.BaoCaoHuHongService;
import java.util.List;

@RestController
@RequestMapping("/api/bao-cao-hong")
 
public class BaoCaoHuHongController {
    @Autowired private BaoCaoHuHongService service;

    @GetMapping
    public List<BaoCaoHuHong> getAll() { return service.getAll(); }

    @PostMapping("/baocao")
    public BaoCaoHuHong taoBaoCao(@RequestBody BaoCaoHuHong bc) {
        return service.thucHienBaoHong(bc);
    }
    @GetMapping("/hienthi")
    public List<BaoCaoHuHong> hienthi(){
    	  return  service.getAll();
    }
    @GetMapping("/xapxep")
    public List<BaoCaoHuHong> xapxep(){
    	 return service.xapxep();
    }
}