package ara.javaBasics.Java.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Read_write {
	 @Test
	 //https://www.baeldung.com/java-file-to-arraylist
	 public void read() throws FileNotFoundException, IOException {
		 ArrayList<String> result = new ArrayList<>();
	try (BufferedReader br = new BufferedReader(new FileReader("C:\\SELENIUM\\readfile\\readfile.txt"))) {
	    while (br.ready() ) {
	    	
	        result.add(br.readLine());
	        System.out.println(result);
	         
	    }
	    for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
			
		} 
	    String first = result.get(0);
	    System.out.println(first);
	}
	
}
	 @AfterTest
	 public void write() {
		 try { 
			 Set<String> keyset = data.keySet(); 
		        int rownum = 0; 
		        for (String key : keyset) { 
		            // this creates a new row in the sheet 
		            Row row = sheet.createRow(rownum++); 
		            Object[] objArr = data.get(key); 
		            int cellnum = 0; 
		            for (Object obj : objArr) { 
		                // this line creates a cell in the next column of that row 
		                Cell cell = row.createCell(cellnum++); 
		                if (obj instanceof String) 
		                    cell.setCellValue((String)obj); 
		                else if (obj instanceof Integer) 
		                    cell.setCellValue((Integer)obj); 
		            } 
		        } 
		        try { 
		            // this Writes the workbook gfgcontribute 
		            FileOutputStream out = new FileOutputStream(new File("gfgcontribute.xlsx")); 
		            workbook.write(out); 
		            out.close(); 
		            System.out.println("gfgcontribute.xlsx written successfully on disk."); 
		        } 
		        catch (Exception e) { 
		            e.printStackTrace(); 
		        }    
		 }	        
}
