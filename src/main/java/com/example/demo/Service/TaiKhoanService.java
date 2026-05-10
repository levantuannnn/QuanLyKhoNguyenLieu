package com.example.demo.Service;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.TaiKhoan;
import com.example.demo.Jpa.*;

@Service
public class TaiKhoanService {
    @Autowired private TaiKhoanRepository repo;

    public TaiKhoan findByUsername(String username) {
        return repo.findByTenDangNhap(username);
    }
    
    public TaiKhoan save(TaiKhoan tk) { return repo.save(tk); }
}