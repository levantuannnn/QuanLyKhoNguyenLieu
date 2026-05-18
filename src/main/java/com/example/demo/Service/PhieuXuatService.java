package com.example.demo.Service;
 

import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
				
				
				DateTimeFormatter formatter =
				        DateTimeFormatter.ofPattern("dd/MM/yyyy");

				String ngayxuatFormat =
				        ngayxuat.format(formatter);
				
				
				String csv =
				    "MaphieuXuat,NgayXuat,BoPhanNhan,LidoXuat,danhsachnguyenlieu,soluong,ghichu\n" +maphieuxuat+","+
				    ngayxuatFormat + "," +BophanNhan+","+
				    lido + "," +
				    danhsach+","+sl+","+ghichu; 
				// Ghi file UTF-8
				Files.writeString(
				        path,
				        csv,
				        StandardCharsets.UTF_8
				);

				// Đọc dữ liệu file
				byte[] originalData = Files.readAllBytes(path);

				// ===== Thêm BOM UTF-8 để Excel đọc đúng tiếng Việt =====
				ByteArrayOutputStream out = new ByteArrayOutputStream();

				out.write(0xEF);
				out.write(0xBB);
				out.write(0xBF);

				out.write(originalData);

				byte[] data = out.toByteArray();

				return data;
		}
 
}