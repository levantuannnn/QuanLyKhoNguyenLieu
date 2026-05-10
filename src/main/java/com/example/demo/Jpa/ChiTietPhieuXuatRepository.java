package com.example.demo.Jpa; // Hoặc .Jpa tùy theo cấu trúc thư mục của bạn

import java.util.List; // QUAN TRỌNG: Thiếu dòng này sẽ bị lỗi đỏ ở chữ List
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.ChiTietPhieuXuat;

@Repository
public interface ChiTietPhieuXuatRepository extends JpaRepository<ChiTietPhieuXuat, ChiTietPhieuXuat> {
    
    // Tìm tất cả chi tiết thuộc về một mã phiếu xuất
    List<ChiTietPhieuXuat> findByMaPhieuXuat(Integer maPhieuXuat);
}