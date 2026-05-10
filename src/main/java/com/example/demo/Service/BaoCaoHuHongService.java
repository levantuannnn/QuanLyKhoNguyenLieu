package com.example.demo.Service;

 

import java.lang.reflect.Array;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Model.BaoCaoHuHong;
import com.example.demo.Config.AppConfig;
import com.example.demo.Jpa.*;

@Service
public class BaoCaoHuHongService {

 
    @Autowired
    private BaoCaoHuHongRepository repo;
    
    @Autowired
    private NguyenLieuService nguyenLieuService; 
    public List<BaoCaoHuHong> getAll() { return repo.findAll(); } 
    public BaoCaoHuHong thucHienBaoHong(BaoCaoHuHong bc) {
         
        BaoCaoHuHong savedBc = repo.save(bc);
         
        nguyenLieuService.updateStock(bc.getNguyenLieu().getMaNguyenLieu(), -bc.getSoLuongHong());
        
        return savedBc;
    }
    public List<BaoCaoHuHong> xapxep(){
    	  List<BaoCaoHuHong> sc=repo.findAll(); 
    	  sc.stream().sorted((a,b)->(int)(b.getSoLuongHong()-a.getSoLuongHong())); 
    	  return sc;
    }
    //tim gia tri lon nhat
    public BaoCaoHuHong maxBaoCao() {
    	 List<BaoCaoHuHong> sc= repo.findAll(); 
    	 sc.stream().sorted((a,b)->(int)(b.getSoLuongHong())-a.getSoLuongHong()); 
    	 return sc.get(sc.size());
    }
    //gia tri nho nhat
    public BaoCaoHuHong minBaoCao() {
   	 List<BaoCaoHuHong> sc= repo.findAll(); 
   	 sc.stream().sorted((a,b)->(int)(b.getSoLuongHong())-a.getSoLuongHong()); 
   	 return sc.get(0);
   }
}