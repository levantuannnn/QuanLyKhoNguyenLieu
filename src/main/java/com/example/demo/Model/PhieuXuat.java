package com.example.demo.Model;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PhieuXuat")
public class PhieuXuat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhieuXuat")
    private Integer maPhieuXuat;

    public PhieuXuat(Integer maPhieuXuat) {
		super();
		this.maPhieuXuat = maPhieuXuat;
	}
    


	@Column(name = "NgayXuat")
    private LocalDate ngayXuat;

    @Column(name = "LyDo")
    private String lyDo;

    @ManyToOne
    @JoinColumn(name = "MaNhanVien")
    private NhanVien nhanVien;
    @Column(name="soluong")
    private Integer soluong;

 
	public PhieuXuat(Integer maPhieuXuat, byte[] image, LocalDate ngayXuat, String lyDo, NhanVien nhanVien,
			Integer soluong) {
		super();
		this.maPhieuXuat = maPhieuXuat;

		this.ngayXuat = ngayXuat;
		this.lyDo = lyDo;
		this.nhanVien = nhanVien;
		this.soluong = soluong;
	}
	public Integer getSoluong() {
	    return soluong;
	}

	public void setSoluong(Integer soluong) {
	    this.soluong = soluong;
	}
	public Integer getMaPhieuXuat() {
		return maPhieuXuat;
	}

	public void setMaPhieuXuat(Integer maPhieuXuat) {
		this.maPhieuXuat = maPhieuXuat;
	}

	public LocalDate getNgayXuat() {
		return ngayXuat;
	}

	public void setNgayXuat(LocalDate ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public PhieuXuat() {}
    // Getter và Setter...
}