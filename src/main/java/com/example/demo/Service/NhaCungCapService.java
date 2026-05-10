package com.example.demo.Service;

 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.NhaCungCap;
import com.example.demo.Jpa.*;

@Service
public class NhaCungCapService {
    @Autowired private NhaCungCapRepository repo; 
    public List<NhaCungCap> getAll() { return repo.findAll(); }
    public NhaCungCap getById(Integer id) { return repo.findById(id).orElse(null); }
    public NhaCungCap save(NhaCungCap ncc) { return repo.save(ncc); }
    public void delete(Integer id) { repo.deleteById(id); }
    public NhaCungCap suancc(int id,NhaCungCap ncc) {
    	NhaCungCap sc = repo.findById(id).orElse(null);
    	if (sc == null) return null;
    	   sc.setDiaChi(ncc.getDiaChi());
    	   sc.setGhiChu(ncc.getGhiChu()); 
    	   sc.setGmail(ncc.getGmail());
    	   sc.setSoDienThoai(ncc.getSoDienThoai());
    	   sc.setTenNhaCungCap(ncc.getTenNhaCungCap()); 
    	  return repo.save(sc);
    }
}