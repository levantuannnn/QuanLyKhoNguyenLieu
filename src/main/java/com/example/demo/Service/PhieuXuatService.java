package com.example.demo.Service;
 

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Model.*;
import com.example.demo.Controler.PhieuNhapController;
import com.example.demo.Jpa.*;

@Service
public class PhieuXuatService {  
     @Autowired 
     private PhieuXuatRepository phieuxuat;
    public byte[] luufile( String maphieuxuat,LocalDate ngayxuat,String BophanNhan,String lido,List<String> nl,int sl, String ghichu) throws Exception { 
				PhieuXuat np=new PhieuXuat();
			 
				Path path = Path.of("phieuxuat.csv"); 
				String danhsach = String.join(";", nl);
				 
				String csv =
				    "MaphieuXuat,NgayXuat,LidoXuat,danhsachnguyenlieu,soluong,ghichu\n" +maphieuxuat+","+
				    ngayxuat + "," +BophanNhan+","+
				    lido + "," +
				    danhsach+","+sl+","+ghichu; 
				Files.writeString(path, csv); 
				byte[] data = Files.readAllBytes(path); 
				return data;
		}
 
}