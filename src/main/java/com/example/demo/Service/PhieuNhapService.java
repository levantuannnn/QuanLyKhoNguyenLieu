package com.example.demo.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Model.*;
import com.example.demo.Jpa.*;

@Service
public class PhieuNhapService {
    @Autowired private PhieuNhapRepository phieuNhapRepo;
    @Autowired private ChiTietPhieuNhapRepository chiTietRepo;
    @Autowired private NguyenLieuService nguyenLieuService;

    public List<PhieuNhap> getAll() { return phieuNhapRepo.findAll(); }

    public  byte[] exportcsv(String ncc,List<String> dsnguyenlieu,int sl,int dongia) throws Exception {
		
		Path path = Path.of("phieunhap.csv"); 
		String danhsach = String.join(";", dsnguyenlieu); 
		String csv =
		  "NhaCungCap,Danhsachnguyenlieu,SoLuong,Dongia\n" + 
		  ncc + "," +
		  danhsach + "," +
		  sl + "," +
		  dongia; 
		 Files.writeString(path, csv);
		 
		byte[] data=Files.readAllBytes(path);
		return data;
  
			}
}