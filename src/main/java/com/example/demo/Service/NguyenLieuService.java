package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

import org.springframework.stereotype.Service;

import com.example.demo.Jpa.NguyenLieuRepository;
import com.example.demo.Model.NguyenLieu;

@Service
public class NguyenLieuService {

    private final NguyenLieuRepository repo;

    // Constructor injection (không cần @Autowired)
    public NguyenLieuService(NguyenLieuRepository repo) {
        this.repo = repo;
    }

    // Cập nhật tồn kho (nhập: amount > 0, xuất: amount < 0)
    public void updateStock(Integer id, Integer amount) {
        NguyenLieu nl = repo.findById(id).orElse(null);
        if (nl != null) {
            int currentStock = (nl.getSoLuongTon() != null) ? nl.getSoLuongTon() : 0;
            nl.setSoLuongTon(currentStock + amount);
            repo.save(nl);
        }
    }

    // Lấy nguyên liệu có số lượng tồn > 5
    public List<NguyenLieu> getStockGreaterThan5() {
        return repo.findAll()
                .stream()
                .filter(nl -> nl.getSoLuongTon() != null && nl.getSoLuongTon() > 5)
                .collect(Collectors.toList());
    }

    // Sắp xếp tăng dần theo số lượng tồn
    public List<NguyenLieu> getSortAsc() {
        return repo.findAll()
                .stream()
                .sorted(Comparator.comparingInt(NguyenLieu::getSoLuongTon))
                .collect(Collectors.toList());
    }

    // Sắp xếp giảm dần theo số lượng tồn
    public List<NguyenLieu> getSortDesc() {
        return repo.findAll()
                .stream()
                .sorted(Comparator.comparingInt(NguyenLieu::getSoLuongTon).reversed())
                .collect(Collectors.toList());
    }

    // Lấy tất cả nguyên liệu
    public List<NguyenLieu> getAll() {
        return repo.findAll();
    }

    // Lấy nguyên liệu theo ID
    public NguyenLieu getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    // Lưu nguyên liệu
    public NguyenLieu save(NguyenLieu nl) {
        return repo.save(nl);
    }

    // Xóa nguyên liệu theo ID
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}