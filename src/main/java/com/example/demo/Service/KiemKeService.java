package com.example.demo.Service;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.KiemKe;
import com.example.demo.Jpa.*;

@Service 
public class KiemKeService {
    @Autowired
    private KiemKeRepository repo;

    public List<KiemKe> getAll() { return repo.findAll(); }
    
    public KiemKe save(KiemKe kk) { return repo.save(kk); }
    
    public void delete(Integer id) { repo.deleteById(id); }
}