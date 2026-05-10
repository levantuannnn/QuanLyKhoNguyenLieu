package com.example.demo.Model;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "BaoCaoHuHong")
public class BaoCaoHuHong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaBaoCao")
    private Integer maBaoCao;

    @ManyToOne
    @JoinColumn(name = "MaNguyenLieu")
    private NguyenLieu nguyenLieu;

    @Column(name = "SoLuongHong")
    private Integer soLuongHong;

    @Column(name = "TinhTrang")
    private String tinhTrang;

    @Column(name = "HinhAnh")
    private String hinhAnh;

    @Column(name = "NgayBaoCao")
    private LocalDate ngayBaoCao;
    
    public BaoCaoHuHong(Integer maBaoCao, NguyenLieu nguyenLieu, Integer soLuongHong, String tinhTrang, String hinhAnh,
			LocalDate ngayBaoCao) {
		super();
		this.maBaoCao = maBaoCao;
		this.nguyenLieu = nguyenLieu;
		this.soLuongHong = soLuongHong;
		this.tinhTrang = tinhTrang;
		this.hinhAnh = hinhAnh;
		this.ngayBaoCao = ngayBaoCao;
	}

	public Integer getMaBaoCao() {
		return maBaoCao;
	}

	public void setMaBaoCao(Integer maBaoCao) {
		this.maBaoCao = maBaoCao;
	}

	public NguyenLieu getNguyenLieu() {
		return nguyenLieu;
	}

	public void setNguyenLieu(NguyenLieu nguyenLieu) {
		this.nguyenLieu = nguyenLieu;
	}

	public Integer getSoLuongHong() {
		return soLuongHong;
	}

	public void setSoLuongHong(Integer soLuongHong) {
		this.soLuongHong = soLuongHong;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public LocalDate getNgayBaoCao() {
		return ngayBaoCao;
	}

	public void setNgayBaoCao(LocalDate ngayBaoCao) {
		this.ngayBaoCao = ngayBaoCao;
	}

	public BaoCaoHuHong() {}
    // Getter và Setter...
}