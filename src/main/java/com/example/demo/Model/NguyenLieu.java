package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "nguyenlieu")
public class NguyenLieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNguyenLieu") // Khớp chính xác với SQL
    private Integer maNguyenLieu;

    @Column(name = "TenNguyenLieu")
    private String tenNguyenLieu;

    @Column(name = "DonVi")
    private String donVi;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "MucToiThieu")
    private Integer mucToiThieu;

    @Column(name = "TrangThai")
    private String trangThai;

    @Column(name = "HinhAnh")
    private String hinhAnh;

	public Integer getMaNguyenLieu() {
		return maNguyenLieu;
	}

	public void setMaNguyenLieu(Integer maNguyenLieu) {
		this.maNguyenLieu = maNguyenLieu;
	}

	public String getTenNguyenLieu() {
		return tenNguyenLieu;
	}

	public void setTenNguyenLieu(String tenNguyenLieu) {
		this.tenNguyenLieu = tenNguyenLieu;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public Integer getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(Integer soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public Integer getMucToiThieu() {
		return mucToiThieu;
	}

	public void setMucToiThieu(Integer mucToiThieu) {
		this.mucToiThieu = mucToiThieu;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public NguyenLieu(Integer maNguyenLieu, String tenNguyenLieu, String donVi, Integer soLuongTon, Integer mucToiThieu,
			String trangThai) {
		super();
		this.maNguyenLieu = maNguyenLieu;
		this.tenNguyenLieu = tenNguyenLieu;
		this.donVi = donVi;
		this.soLuongTon = soLuongTon;
		this.mucToiThieu = mucToiThieu;
		this.trangThai = trangThai;
		
	}

	public NguyenLieu() {
		super();
		 
	}

   }