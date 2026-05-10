package com.example.demo.Model;

import jakarta.persistence.*;
import java.time.LocalDate; // Nên dùng LocalDate cho kiểu DATE trong SQL

@Entity
@Table(name = "PhieuNhap") // Viết hoa đúng như SQL
public class PhieuNhap {

    public PhieuNhap(Integer maPhieuNhap, LocalDate ngayNhap, NhaCungCap nhaCungCap, NhanVien nhanVien,
			String nguoiGiaoHang) {
		super();
		this.maPhieuNhap = maPhieuNhap;
		this.ngayNhap = ngayNhap;
		this.nhaCungCap = nhaCungCap;
		this.nhanVien = nhanVien;
		this.nguoiGiaoHang = nguoiGiaoHang;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhieuNhap") // Khớp chính xác SQL
    private Integer maPhieuNhap;

    @Column(name = "NgayNhap")
    private LocalDate ngayNhap; // Trong SQL là DATE, dùng LocalDate sẽ chuẩn hơn String

    @ManyToOne
    @JoinColumn(name = "MaNhaCungCap") // Viết hoa đúng tên cột khóa ngoại
    private NhaCungCap nhaCungCap;

    @ManyToOne
    @JoinColumn(name = "MaNhanVien") // Viết hoa đúng tên cột khóa ngoại
    private NhanVien nhanVien;

    @Column(name = "NguoiGiaoHang")
    private String nguoiGiaoHang;

    // Constructor mặc định
    public PhieuNhap() {
    }

    // Getter và Setter
    public Integer getMaPhieuNhap() { return maPhieuNhap; }
    public void setMaPhieuNhap(Integer maPhieuNhap) { this.maPhieuNhap = maPhieuNhap; }

    public LocalDate getNgayNhap() { return ngayNhap; }
    public void setNgayNhap(LocalDate ngayNhap) { this.ngayNhap = ngayNhap; }

    public NhaCungCap getNhaCungCap() { return nhaCungCap; }
    public void setNhaCungCap(NhaCungCap nhaCungCap) { this.nhaCungCap = nhaCungCap; }

    public NhanVien getNhanVien() { return nhanVien; }
    public void setNhanVien(NhanVien nhanVien) { this.nhanVien = nhanVien; }

    public String getNguoiGiaoHang() { return nguoiGiaoHang; }
    public void setNguoiGiaoHang(String nguoiGiaoHang) { this.nguoiGiaoHang = nguoiGiaoHang; }
}