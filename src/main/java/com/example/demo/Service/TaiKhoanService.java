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
    
    public void  save(String username,String password) {
    	 TaiKhoan tk= new TaiKhoan();
    	 tk.setTenDangNhap(username);
    	 tk.setMatKhau(password);
    	 
    		 repo.save(tk);
     
    }
    public boolean xoataikhoan(int id) {
    	  TaiKhoan tk=repo.findById(id).orElse(null);
    	  if(tk==null) {
    		   return false;
    	  }
    	  else {
    		   repo.delete(tk);
    		   return true;
    	  }
    }
}