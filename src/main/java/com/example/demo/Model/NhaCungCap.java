package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "NhaCungCap") // Viết hoa đúng như SQL: CREATE TABLE NhaCungCap
public class NhaCungCap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNhaCungCap") // Khớp chính xác cột PK
    private Integer maNhaCungCap;

    @Column(name = "TenNhaCungCap")
    private String tenNhaCungCap;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @Column(name = "Gmail") // Bạn đang thiếu cột này so với SQL
    private String gmail;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "GhiChu") // Bạn đang thiếu cột này so với SQL (kiểu TEXT)
    private String ghiChu;

    // 1. Constructor mặc định
    public NhaCungCap() {
    }

    // 2. Getter và Setter (Alt + Shift + S -> R trong Eclipse)
    public Integer getMaNhaCungCap() { return maNhaCungCap; }
    public void setMaNhaCungCap(Integer maNhaCungCap) { this.maNhaCungCap = maNhaCungCap; }

    public String getTenNhaCungCap() { return tenNhaCungCap; }
    public void setTenNhaCungCap(String tenNhaCungCap) { this.tenNhaCungCap = tenNhaCungCap; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public String getGmail() { return gmail; }
    public void setGmail(String gmail) { this.gmail = gmail; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }

	public NhaCungCap(Integer maNhaCungCap, String tenNhaCungCap, String soDienThoai, String gmail, String diaChi,
			String ghiChu) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.soDienThoai = soDienThoai;
		this.gmail = gmail;
		this.diaChi = diaChi;
		this.ghiChu = ghiChu;
	}
}