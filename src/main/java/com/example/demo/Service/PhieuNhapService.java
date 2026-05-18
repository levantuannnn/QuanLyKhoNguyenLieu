package com.example.demo.Service;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.*;
import com.example.demo.Jpa.*;

@Service
public class PhieuNhapService {

    @Autowired
    private PhieuNhapRepository phieuNhapRepo;

    @Autowired
    private ChiTietPhieuNhapRepository chiTietRepo;

    @Autowired
    private NguyenLieuService nguyenLieuService;

    public List<PhieuNhap> getAll() {
        return phieuNhapRepo.findAll();
    }

    public byte[] exportcsv(
            String maphieunhap,
            LocalDate ngaynhap,
            String ncc,
            String giaohang,
            List<String> dsnguyenlieu,
            int sl,
            int dongia,
            String ghichu
    ) throws Exception {

        Path path = Path.of("phieunhap.csv");

        String danhsach = String.join(";", dsnguyenlieu);

    	DateTimeFormatter formatter =
		        DateTimeFormatter.ofPattern("dd/MM/yyyy");

		String ngaynhapFormat =
		        ngaynhap.format(formatter);
        // Thêm dấu tab để Excel hiểu là text
        // tránh lỗi #### hoặc format sai
        String csv =
            "Maphieunhap,NgayNhap,NhaCungCap,NguoiGiaoHang,Danhsachnguyenlieu,SoLuong,Dongia,Ghichu\n" +
            "\t" + maphieunhap + "," +ngaynhapFormat+","+
            ncc + "," +giaohang+","+
            danhsach + "," +
            sl + "," +
            dongia + "," +
            ghichu;

        // Ghi UTF-8
        Files.writeString(
                path,
                csv,
                StandardCharsets.UTF_8
        );

        // Đọc file
        byte[] originalData = Files.readAllBytes(path);

        // ===== UTF-8 BOM cho Excel đọc tiếng Việt =====
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        out.write(0xEF);
        out.write(0xBB);
        out.write(0xBF);

        out.write(originalData);

        byte[] data = out.toByteArray();

        return data;
    }
}