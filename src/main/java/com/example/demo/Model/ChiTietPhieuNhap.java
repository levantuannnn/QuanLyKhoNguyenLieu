package com.example.demo.Model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ChiTietPhieuNhap")
@IdClass(ChiTietPhieuNhap.class) // Sử dụng chính class này để định danh ID
public class ChiTietPhieuNhap implements Serializable {
 
	@Id
    @Column(name = "MaPhieuNhap")
    private Integer maPhieuNhap;

 
	@Id
    @Column(name = "MaNguyenLieu")
    private Integer maNguyenLieu;

    public ChiTietPhieuNhap(Integer maPhieuNhap, Integer maNguyenLieu, Integer soLuong, Double donGia,
			PhieuNhap phieuNhap, NguyenLieu nguyenLieu) {
		super();
		this.maPhieuNhap = maPhieuNhap;
		this.maNguyenLieu = maNguyenLieu;
		this.soLuong = soLuong;
 
		this.donGia = donGia;
		this.phieuNhap = phieuNhap;
		this.nguyenLieu = nguyenLieu;
	}
	@Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Double donGia;

    @ManyToOne
    @MapsId("maPhieuNhap")
    @JoinColumn(name = "MaPhieuNhap")
    private PhieuNhap phieuNhap;

    @ManyToOne
    @MapsId("maNguyenLieu")
    @JoinColumn(name = "MaNguyenLieu")
    private NguyenLieu nguyenLieu;

    // 1. Constructor mặc định
    public ChiTietPhieuNhap() {}

    // 2. Cần Override equals và hashCode trực tiếp ở đây để JPA hiểu khóa phức hợp
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietPhieuNhap that = (ChiTietPhieuNhap) o;
        return Objects.equals(maPhieuNhap, that.maPhieuNhap) && 
               Objects.equals(maNguyenLieu, that.maNguyenLieu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPhieuNhap, maNguyenLieu);
    }

    // 3. Getter và Setter (Generate nhanh bằng Alt + Shift + S -> R)
    public Integer getMaPhieuNhap() { return maPhieuNhap; }
    public void setMaPhieuNhap(Integer maPhieuNhap) { this.maPhieuNhap = maPhieuNhap; }
    public Integer getMaNguyenLieu() { return maNguyenLieu; }
    public void setMaNguyenLieu(Integer maNguyenLieu) { this.maNguyenLieu = maNguyenLieu; }
    public Integer getSoLuong() { return soLuong; }
    public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; }
    public Double getDonGia() { return donGia; }
    public void setDonGia(Double donGia) { this.donGia = donGia; }
    public PhieuNhap getPhieuNhap() { return phieuNhap; }
    public void setPhieuNhap(PhieuNhap phieuNhap) { this.phieuNhap = phieuNhap; }
    public NguyenLieu getNguyenLieu() { return nguyenLieu; }
    public void setNguyenLieu(NguyenLieu nguyenLieu) { this.nguyenLieu = nguyenLieu; }
}