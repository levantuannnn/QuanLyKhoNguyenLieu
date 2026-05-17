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
    public byte[] luufile( LocalDate ngayxuat,String lido,List<String> nl) throws Exception { 
				PhieuXuat np=new PhieuXuat();
			 
				Path path = Path.of("phieuxuat.csv"); 
				String danhsach = String.join(";", nl);
				 
				String csv =
				    "NgayXuat,LidoXuat,danhsachnguyenlieu\n" +
				    ngayxuat + "," +
				    lido + "," +
				    danhsach; 
				Files.writeString(path, csv); 
				byte[] data = Files.readAllBytes(path); 
				np.setImage(data); 
			    return np.getImage();
		}
 
}