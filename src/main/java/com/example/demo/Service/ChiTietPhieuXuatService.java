package com.example.demo.Service;

 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.ChiTietPhieuXuat;
import com.example.demo.Jpa.*;

@Service
public class ChiTietPhieuXuatService {
    @Autowired
    private ChiTietPhieuXuatRepository repo;

    public List<ChiTietPhieuXuat> getByMaPhieu(Integer maPhieu) {
        return repo.findByMaPhieuXuat(maPhieu);
    }

    public ChiTietPhieuXuat save(ChiTietPhieuXuat ct) {
        return repo.save(ct);
    }
}