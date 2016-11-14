package qccAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TestClass {

	private static WebDriver driver = null;

	public void QCC_Login(WebDriver myDriver) throws Exception
	{
	               driver = myDriver;
	               
	         //System.setProperty("webdriver.firefox.marionette","C:\\geckodriver\\geckodriver.exe");
	               
	               //driver = new FirefoxDriver();
	               
	               //driver.manage().window().maximize();
	               
	               //driver = myDirver;

	               //driver.get("http://10.7.247.181/");
	               
	               driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	               
	               driver.findElement(By.id("loginLink")).click();
	               
	               try {

	                              FileInputStream file = new FileInputStream(new File(
	                                                            "C:\\Users\\Sakshi.Jain\\Desktop\\Login.xlsx"));
	                              XSSFWorkbook workbook = new XSSFWorkbook(file);

	                              XSSFSheet sheet = workbook.getSheetAt(0);

	                              for (int i = 1; i <= sheet.getLastRowNum(); i++) {

	               //System.out.println(sheet.getLastRowNum());

	               String userName = sheet.getRow(i).getCell(0).getStringCellValue();                                           
	               
	               driver.findElement(By.id("UserName")).sendKeys(userName);
	               
	               String Password = sheet.getRow(i).getCell(1).getStringCellValue();
	               
	               driver.findElement(By.id("Password")).sendKeys(Password);
	               
	               driver.findElement(By.xpath("//input[contains(@class, 'btn btn-primary')]")).click();                                        
	               try{
	               if (driver.findElement(By.xpath("//a[contains(@class,'username')]")).isDisplayed())
	               {
	                              String LoginName = driver.findElement(By.xpath("//a[contains(@class,'username')]")).getText();
	                              
	                              if (LoginName.contains("virendra.rawat@travelport.com")){
	                                             
	                                             System.out.println("user login successfull");
	                                             sheet.getRow(i).createCell(2).setCellValue("user login successfull");
	                                             
	                              }              
	                              else{
	                                             System.out.println("User Login with different credentials");
	                                             sheet.getRow(i).createCell(2).setCellValue("User Login with different credentials");
	                              }
	                              
	               }
	               }
	               catch(Exception e){
	                              System.out.println("user login fail");
	                              sheet.getRow(i).createCell(2).setCellValue("user login fail");         
	               }                             
	               
	               
	}              
	                              file.close();
	                              FileOutputStream outFile = new FileOutputStream(new File(
	                                                            "C:\\Users\\Sakshi.Jain\\Desktop\\Login.xlsx"));
	                              workbook.write(outFile);
	                              outFile.close();
	                              workbook.close();}catch(Exception e){
	                              throw(e);} 
	               }
	}
