package com.example.demo.Controler;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.TaiKhoan;
import com.example.demo.Service.TaiKhoanService;
import java.util.List;

@RestController
@RequestMapping("/api/tai-khoan")
 
public class TaiKhoanController {

    @Autowired 
    private TaiKhoanService service;

    // Lấy danh sách tất cả tài khoản (Dành cho Admin)
    @GetMapping
    public List<TaiKhoan> getAll() {
        // Bạn cần bổ sung hàm getAll() trong TaiKhoanService và Repository nếu muốn dùng
        return null; 
    }

    // Đăng ký tài khoản mới
    @PostMapping("/register")
    public TaiKhoan register(@RequestBody TaiKhoan tk) {
        return service.save(tk);
    }

    // API Đăng nhập đơn giản
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody TaiKhoan tk) {
        // 1. Tìm user trong DB
        TaiKhoan user = service.findByUsername(tk.getTenDangNhap());

        // 2. Kiểm tra user tồn tại và mật khẩu khớp (nên dùng .equals)
        if (user != null && user.getMatKhau().equals(tk.getMatKhau())) {
            // Trả về Object user (JSON) - Frontend sẽ không còn lỗi Unexpected token 'Đ'
            return ResponseEntity.ok(user);
        }

        // 3. Nếu sai, trả về lỗi 401
        return ResponseEntity.status(401).body("Sai tài khoản hoặc mật khẩu");
    }
}