package com.example.demo.Model;

import java.util.Date; // Sử dụng java.util.Date thay vì LocalDate để ổn định hơn

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "KiemKe")
public class KiemKe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKiemKe") 
    private Integer maKiemKe;

    @ManyToOne
    @JoinColumn(name = "MaNguyenLieu")
    private NguyenLieu nguyenLieu;

    @Column(name = "SoLuongThuc")
    private Integer soLuongThuc;

    @Column(name = "LyDo")
    private String lyDo;

    @Column(name = "NgayKiemKe")
    @Temporal(TemporalType.DATE) // Quan trọng: Giúp Hibernate hiểu đây là kiểu ngày tháng
    private Date ngayKiemKe;

    // Constructor mặc định
    public KiemKe() {}

    // Constructor đầy đủ
    public KiemKe(Integer maKiemKe, NguyenLieu nguyenLieu, Integer soLuongThuc, String lyDo, Date ngayKiemKe) {
        this.maKiemKe = maKiemKe;
        this.nguyenLieu = nguyenLieu;
        this.soLuongThuc = soLuongThuc;
        this.lyDo = lyDo;
        this.ngayKiemKe = ngayKiemKe;
    }

    // --- Getter và Setter ---
    public Integer getMaKiemKe() { return maKiemKe; }
    public void setMaKiemKe(Integer maKiemKe) { this.maKiemKe = maKiemKe; }

    public NguyenLieu getNguyenLieu() { return nguyenLieu; }
    public void setNguyenLieu(NguyenLieu nguyenLieu) { this.nguyenLieu = nguyenLieu; }

    public Integer getSoLuongThuc() { return soLuongThuc; }
    public void setSoLuongThuc(Integer soLuongThuc) { this.soLuongThuc = soLuongThuc; }

    public String getLyDo() { return lyDo; }
    public void setLyDo(String lyDo) { this.lyDo = lyDo; }

    public Date getNgayKiemKe() { return ngayKiemKe; }
    public void setNgayKiemKe(Date ngayKiemKe) { this.ngayKiemKe = ngayKiemKe; }
}