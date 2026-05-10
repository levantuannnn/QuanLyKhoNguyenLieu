package com.example.demo.Service;
 
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.NhanVien;
import com.example.demo.Controler.NhaCungCapController;
import com.example.demo.Jpa.*;

@Service
public class NhanVienService { 
    @Autowired private NhanVienRepository repo; 
    public List<NhanVien> getAll() { return repo.findAll(); }
    public NhanVien getById(Integer id) { return repo.findById(id).orElse(null); }
    public  NhanVien save(NhanVien nv) {
    	   if(repo.existsByTenNhanVien(nv.getTenNhanVien())) {
    		    return null;
    	   }
    	  return repo.save(nv);
    	  
    	   
    }
    public void delete(Integer id) { repo.deleteById(id); }
    public Boolean capnhat(Integer id,NhanVien sc) {
    	   
    	   if(repo.existsByTenNhanVien(sc.getTenNhanVien())) {
    		    return false;
    	   }
    	   sc.setSoDienThoai(sc.getSoDienThoai());
    	   sc.setTenNhanVien(sc.getTenNhanVien());
    	   repo.save(sc);
    	  return true;
    }
    public List<NhanVien> timnv(String tennv){
    	 return repo.findByTenNhanVien(tennv);
    }
   
}