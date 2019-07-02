package ara.javaBasics.Java.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Readexcel
{
	WebDriver driver;
	WebDriver wait;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;

 @BeforeTest
 public void TestSetup() throws Exception 
{
	// Set the path of the Firefox driver.
	 System.setProperty("webdriver.chrome.driver","C:\\SELENIUM\\webDriver\\chromedriver\\chromedriver.exe");
	  WebDriver driver = new WebDriver();
	
	// Enter url.
	driver.get("http://www.linkedin.com/");
	//driver.manage().window().maximize();
	
	wait = new WebDriver(driver,30);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.findElement(By.id("reg-firstname")).sendKeys("arafath11");
	this.takeSnapShot(driver, "C:\\selenium_Screenshots\\test.png") ;
	 System.out.println("passed");
	
}
 
 @Test
public void ReadData() throws IOException 
 {
	 // Import excel sheet.
	 File src=new File("C:\\Users\\ap82\\Desktop\\arafath1.xlsx");
	 
	 // Load the file.
	 FileInputStream finput = new FileInputStream(src);
	 
	 // Load the workbook.
	workbook = new XSSFWorkbook(finput);
	 
     // Load the sheet in which data is stored.
	 sheet= workbook.getSheetAt(1); //excel sheet no:(0,1,2,3,4,etc..,)
	 System.out.println("load workbook");
	 
	 
	 
	 for(int i=0; i<=sheet.getLastRowNum(); i++)
	 {
		 // Import data for Email.
		 cell = sheet.getRow(i).getCell(0);
		 cell.setCellType(Cell.CELL_TYPE_STRING);
		 System.out.println("111");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.id("reg-lastname")).sendKeys(cell.getStringCellValue());
		 System.out.println("222");
		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 // Import data for password.
		 cell = sheet.getRow(i).getCell(1);
		 cell.setCellType(Cell.CELL_TYPE_STRING);
		 driver.findElement(By.id("login-password")).sendKeys(cell.getStringCellValue());
		 
		 
		 // Write data in the excel.
		   
		FileOutputStream foutput =new FileOutputStream(src);
		 foutput.close();  //refer  https://stackoverflow.com/questions/12519335/resource-leak-in-is-never-closed   //It will close Scanner and shut the warning.
		
			
			// Specify the message needs to be written.
			String message = "Data Imported Successfully.";
			
			// Create cell where data needs to be written.
			sheet.getRow(i).createCell(3).setCellValue(message);
			 
			// Specify the file in which data needs to be written.
		    FileOutputStream fileOutput = new FileOutputStream(src);
		    
		    // finally write content
		    workbook.write(fileOutput);
			
		     // close the file
		    fileOutput.close();
		   		
        }
  } 


public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

    //Convert web driver object to TakeScreenshot

    TakesScreenshot MyShot =((TakesScreenshot)webdriver);

    //Call getScreenshotAs method to create image file

            File SrcFile=MyShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

            File DestFile=new File(fileWithPath);

            //Copy file at destination

            Files.copyFile(SrcFile, DestFile);

}
}
