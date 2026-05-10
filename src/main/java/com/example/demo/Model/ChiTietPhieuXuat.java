package com.example.demo.Model;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
@Entity
@Table(name = "ChiTietPhieuXuat")
@IdClass(ChiTietPhieuXuat.class)
public class ChiTietPhieuXuat implements Serializable {
    public ChiTietPhieuXuat(Integer maPhieuXuat, Integer maNguyenLieu, Integer soLuong) {
		super();
		this.maPhieuXuat = maPhieuXuat;
		this.maNguyenLieu = maNguyenLieu;
		this.soLuong = soLuong;
	}

	@Id
    @Column(name = "MaPhieuXuat")
    private Integer maPhieuXuat;

    @Id
    @Column(name = "MaNguyenLieu")
    private Integer maNguyenLieu;

    @Column(name = "SoLuong")
    private Integer soLuong;

    public ChiTietPhieuXuat() {}
    // Getter và Setter...

	public Integer getMaPhieuXuat() {
		return maPhieuXuat;
	}

	public void setMaPhieuXuat(Integer maPhieuXuat) {
		this.maPhieuXuat = maPhieuXuat;
	}

	public Integer getMaNguyenLieu() {
		return maNguyenLieu;
	}

	public void setMaNguyenLieu(Integer maNguyenLieu) {
		this.maNguyenLieu = maNguyenLieu;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}
}