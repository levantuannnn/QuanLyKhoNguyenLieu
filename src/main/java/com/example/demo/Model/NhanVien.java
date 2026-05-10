package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "NhanVien") // Khớp với CREATE TABLE NhanVien
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNhanVien")
    private Integer maNhanVien;

    @Column(name = "TenNhanVien")
    private String tenNhanVien;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

    // Cột MaTaiKhoan trong SQL là khóa ngoại liên kết với bảng TaiKhoan
    @Column(name = "MaTaiKhoan")
    private Integer maTaiKhoan;

    // Constructor mặc định
    public NhanVien() {}

    // Getter và Setter
    public Integer getMaNhanVien() { return maNhanVien; }
    public void setMaNhanVien(Integer maNhanVien) { this.maNhanVien = maNhanVien; }

    public NhanVien(Integer maNhanVien, String tenNhanVien, String soDienThoai, Integer maTaiKhoan) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.soDienThoai = soDienThoai;
		this.maTaiKhoan = maTaiKhoan;
	}

	public String getTenNhanVien() { return tenNhanVien; }
    public void setTenNhanVien(String tenNhanVien) { this.tenNhanVien = tenNhanVien; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public Integer getMaTaiKhoan() { return maTaiKhoan; }
    public void setMaTaiKhoan(Integer maTaiKhoan) { this.maTaiKhoan = maTaiKhoan; }
}