package qccAutomation;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
//import java.io.FileNotFoundException;

//import java.io.FileOutputStream;
//import org.openqa.selenium.support.ui.Select;

//import org.apache.poi.xssf.usermodel.XSSFCell;

//import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;



public class User {
public static WebDriver driver;
	
	public void CreateUser(WebDriver mydriver) throws Exception
	{
       driver = mydriver;
	   
	   FileInputStream excelfile  = new FileInputStream("C:\\Users\\virendra.rawat\\Documents\\tc.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
	   XSSFSheet sheet = workbook.getSheetAt(1);
	   
	   driver.findElement(By.xpath("//a[@href = '/User']")).click();
	   driver.findElement(By.xpath("//a[@href = '/User/Create']")).click();
	   String emailadd= sheet.getRow(1).getCell(1).getStringCellValue();                                           
       
       driver.findElement(By.xpath("//input[@id = 'Name']")).sendKeys(emailadd);      
       String Password = sheet.getRow(1).getCell(2).getStringCellValue();
       
       driver.findElement(By.xpath("//input[@id = 'Password']")).sendKeys(Password);
       
       String ConfirmPassword = sheet.getRow(1).getCell(3).getStringCellValue();
       driver.findElement(By.xpath("//input[@id = 'ConfirmPassword']")).sendKeys(ConfirmPassword);
       
       String agencyid = sheet.getRow(1).getCell(4).getStringCellValue();
       driver.findElement(By.id("AgencyId")).sendKeys(agencyid);
       
       String role = sheet.getRow(1).getCell(5).getStringCellValue();
       driver.findElement(By.id("RoleName")).sendKeys(role);
       driver.findElement(By.xpath("//input[@value = 'Create']")).submit();
	   
	   workbook.close();
	}
	
	
	
	public void Edituser(WebDriver mydriver) throws Exception

	{
		   FileInputStream excelfile  = new FileInputStream("C:\\Users\\virendra.rawat\\Documents\\tc.xlsx");
		   XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
		   XSSFSheet sheet = workbook.getSheetAt(1);	
	driver = mydriver;
	driver.findElement(By.xpath("//a[@href = '/User']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//th[@data-title = 'Email Address']//span[@class = 'k-icon k-filter']")).click();
	 String Emailadd = sheet.getRow(4).getCell(1).getStringCellValue();  
	 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	 //Line added on 21st Oct.
	 driver.findElement(By.xpath("//input[@data-bind = 'value:filters[0].value']")).click();
	 
	 driver.findElement(By.xpath("//input[@data-bind = 'value:filters[0].value']")).sendKeys(Emailadd);
	driver.findElement(By.xpath("//button[@type = 'submit']")).click();
	Thread.sleep(1000);
	
	//driver.findElement(By.xpath("//td//a[@href = '/User/Details/319']")).submit();
	driver.findElement(By.xpath("//td[@role = 'gridcell']//a[contains(@href,'Edit')]")).click();
	String role = sheet.getRow(4).getCell(3).getStringCellValue();
    driver.findElement(By.id("RoleName")).sendKeys(role);
    driver.findElement(By.xpath("//input[@type='submit']")).click();
	workbook.close();
	}
	
	public void activateuser(WebDriver mydriver) throws Exception

	{
		   FileInputStream excelfile  = new FileInputStream("C:\\Users\\virendra.rawat\\Documents\\tc.xlsx");
		   XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
		   XSSFSheet sheet = workbook.getSheetAt(1);	
	driver = mydriver;
	driver.findElement(By.xpath("//a[@href = '/User']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//th[@data-title = 'Email Address']//span[@class = 'k-icon k-filter']")).click();
	 String Emailadd = sheet.getRow(4).getCell(1).getStringCellValue();   
	 //Line added on 21stOct.
	 driver.findElement(By.xpath("//input[@data-bind = 'value:filters[0].value']")).click();;
	 
	 driver.findElement(By.xpath("//input[@data-bind = 'value:filters[0].value']")).sendKeys(Emailadd);
	driver.findElement(By.xpath("//button[@type = 'submit']")).click();
	Thread.sleep(1000);
	
	//driver.findElement(By.xpath("//td//a[@href = '/User/Details/319']")).submit();
	driver.findElement(By.xpath("//td[@role = 'gridcell']//a[contains(@href,'ChangeStatus')]")).click();
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	workbook.close();
	}
	
	public void deleteuser(WebDriver mydriver) throws Exception

	{
		   FileInputStream excelfile  = new FileInputStream("C:\\Users\\virendra.rawat\\Documents\\tc.xlsx");
		   XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
		   XSSFSheet sheet = workbook.getSheetAt(1);	
	driver = mydriver;
	driver.findElement(By.xpath("//a[@href = '/User']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//th[@data-title = 'Email Address']//span[@class = 'k-icon k-filter']")).click();
	 String Emailadd = sheet.getRow(4).getCell(1).getStringCellValue();
	 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	 //line added on 21st Oct
	 driver.findElement(By.xpath("//input[@data-bind = 'value:filters[0].value']")).click();
	 
	 driver.findElement(By.xpath("//input[@data-bind = 'value:filters[0].value']")).sendKeys(Emailadd);
	driver.findElement(By.xpath("//button[@type = 'submit']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//td[@role = 'gridcell']//a[contains(@href,'Details')]")).click();
	driver.findElement(By.xpath("//a[contains(@href, 'DeleteUser')]")).click();
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	workbook.close();
	}
	}

       
       
       

