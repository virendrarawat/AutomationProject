package qccAutomation;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccessMethod {
	public static WebDriver driver;
	
	public void CreateAccess(WebDriver adriver) throws Exception {
		
		driver = adriver;
		
		FileInputStream excelfile  = new FileInputStream("C:\\Users\\virendra.rawat\\Documents\\Login.xlsx");
		   @SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
		   XSSFSheet sheet = workbook.getSheetAt(1);
		
		//Access Method
		driver.findElement(By.xpath("//a[@href='/AccessMethod']")).click();
		driver.findElement(By.xpath("//div[contains(@class, 'container')]//a[@href='/AccessMethod/Create']")).click();
		
		String Name = sheet.getRow(1).getCell(0).getStringCellValue();
		driver.findElement(By.id("Name")).sendKeys(Name);
		
		//Agency Dropdown
		String Agency = sheet.getRow(1).getCell(1).getStringCellValue();
		Select aselect = new Select(driver.findElement(By.id("AgencyId")));
		aselect.selectByVisibleText(Agency);
		
		//API Dropdown
		String ApiType = sheet.getRow(1).getCell(2).getStringCellValue();
		Select gselect = new Select(driver.findElement(By.id("ApiType")));
		gselect.selectByVisibleText(ApiType);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//checkbox
		driver.findElement(By.id("Active")).click();
		String Pcc = sheet.getRow(1).getCell(3).getStringCellValue();
		driver.findElement(By.id("Pcc")).sendKeys(Pcc);
		String UserName = sheet.getRow(1).getCell(4).getStringCellValue();
		driver.findElement(By.id("UserName")).sendKeys(UserName);
		String Password = sheet.getRow(1).getCell(5).getStringCellValue();
		driver.findElement(By.id("Password")).sendKeys(Password);
		String Hap = sheet.getRow(1).getCell(6).getStringCellValue();
		driver.findElement(By.id("SecondaryUserData")).sendKeys(Hap);
		String ServerUrl = sheet.getRow(1).getCell(7).getStringCellValue();
		driver.findElement(By.id("ServerUrl")).sendKeys(ServerUrl);
		driver.findElement(By.xpath("//input[@name='Add:Validate']")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Create Access Method if Access Method is validated.
		String text = driver.findElement(By.xpath(".//*[@id='wrap']/div[2]/div")).getText();
			
	if(text.contains("Credentials were accepted by web service."))
	{
		driver.findElement(By.xpath("//input[@name='Add:Create']")).click();
		System.out.println("Access Method is created successfully");
	}
	else
	{
		driver.findElement(By.xpath("//a[@class ='btn btn-default']"));
		System.out.println("Credentials were incorrect");
	}
	}
	
	//Edit Access method
	public void EditAccess(WebDriver edriver) throws Exception{
		
		driver = edriver;
		FileInputStream excelfile  = new FileInputStream("C:\\Users\\virendra.rawat\\Documents\\Login.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
		   XSSFSheet sheet = workbook.getSheetAt(3);
		driver.findElement(By.xpath("//a[@href='/AccessMethod']")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//th[@data-title='Agency']//span[@class='k-icon k-filter']")).click();
		String Agency = sheet.getRow(1).getCell(0).getStringCellValue();
		driver.findElement(By.xpath("//input[contains(@data-bind, 'filters[0]')]")).click();
		driver.findElement(By.xpath("//input[contains(@data-bind, 'filters[0]')]")).sendKeys(Agency);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//double id = sheet.getRow(1).getCell(1).getNumericCellValue();		
		
		//System.out.println(id);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(@href, 'Edit')]")).click();
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href='/AccessMethod']")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
		
		
		workbook.close();
	}
	
	//Deactivate Access method
	public void DeactivateAccess(WebDriver adriver) throws Exception {
		driver = adriver;
		FileInputStream excelfile  = new FileInputStream("C:\\Users\\virendra.rawat\\Documents\\Login.xlsx");
		   @SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
		   XSSFSheet sheet = workbook.getSheetAt(3);
		driver.findElement(By.xpath("//a[@href='/AccessMethod']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//th[@data-title='Agency']//span[@class='k-icon k-filter']")).click();
		String Agency = sheet.getRow(1).getCell(0).getStringCellValue();
		//Line added on 21st Oct.
		driver.findElement(By.xpath("//input[contains(@data-bind, 'filters[0]')]")).click();
		
		driver.findElement(By.xpath("//input[contains(@data-bind, 'filters[0]')]")).sendKeys(Agency);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		double id = sheet.getRow(1).getCell(1).getNumericCellValue();		
		
		System.out.println(id);
		driver.findElement(By.xpath("//a[contains(@href, 'ChangeStatus/"+(int)id+"')]")).click();
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		
	}
	
	//Delete Access method
	public void DeleteAccess(WebDriver adriver) throws Exception {
		driver = adriver;
		FileInputStream excelfile  = new FileInputStream("C:\\Users\\virendra.rawat\\Documents\\Login.xlsx");
		   @SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
		   XSSFSheet sheet = workbook.getSheetAt(2);
		driver.findElement(By.xpath("//a[@href='/AccessMethod']")).click();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		Thread.sleep(1000);
		
		//Search Access Method and Delete it
		
		driver.findElement(By.xpath("//th[@data-title='Agency']//span[@class='k-icon k-filter']")).click();
		String Agency = sheet.getRow(1).getCell(0).getStringCellValue();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[contains(@data-bind, 'filters[0]')]")).click();
		
		driver.findElement(By.xpath("//input[contains(@data-bind, 'filters[0]')]")).sendKeys(Agency);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		//double id = sheet.getRow(1).getCell(1).getNumericCellValue();		
		driver.findElement(By.xpath("//a[contains(@href, 'Delete/')]")).click();
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		
		String dtext = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
		if(dtext.contains("has been deleted"))
		{
			System.out.println("Access method deleted successfully.");
		}
		else
		{
			System.out.println("Access Method has not been deleted successfully");
		}
			
		}
}
