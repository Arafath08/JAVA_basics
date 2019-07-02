package ara.javaBasics.Java.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Read_text_write_excel {
	
	
	 @BeforeTest
	 public void read() {
	  
	    try (BufferedReader br = new BufferedReader(new FileReader("C:\\SELENIUM\\readfile\\readfile.txt"))) {
	    	StringBuffer stringBuffer = new StringBuffer();
	        String sCurrentLine;
	        
	        while ((sCurrentLine = br.readLine()) != null) {
	        	String line = null ;
				stringBuffer.append(line);
	        	stringBuffer.append("\n");
	        	 System.out.println(sCurrentLine);                 
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	 }
	 
	 @Test
	 public void write() throws IOException {
	    LinkedList<String[]> text_lines = new LinkedList<>();
	    try (BufferedReader br = new BufferedReader(new FileReader("C:\\SELENIUM\\readfile\\readfile.txt"))) {
	        String sCurrentLine;
	        while ((sCurrentLine = br.readLine()) != null) {
	        	 System.out.println(sCurrentLine);                 
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    String fileName = "C:\\SELENIUM\\readfile\\write.xls";
	    Workbook workbook = new HSSFWorkbook();
	    Sheet sheet = workbook.createSheet("Teste");
	    int row_num =0;
	    for(String[] line : text_lines){
	        Row row = sheet.createRow(row_num++);
	        int cell_num = 0;
	        for(String value : line){
	            Cell cell = row.createCell(cell_num++);
	            cell.setCellValue(value);
	        }
	    }

	    FileOutputStream fileOut = new FileOutputStream(fileName);
	    workbook.write(fileOut);
	    fileOut.close();
}
}

