package qccAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SupportRegions{
	public static WebDriver driver;
		
	//create region
	public void addregion(WebDriver mydriver) throws Exception
	{
	driver = mydriver;
	/*
	FileInputStream excelfile  = new FileInputStream("C:\\Data\\Selenium\\tc.xlsx");
	   @SuppressWarnings("resource")
	XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
	   XSSFSheet sheet = workbook.getSheetAt(4);
	 */
	  
	driver.findElement(By.xpath("//a[@href = '/SupportRegion']")).click();
	driver.findElement(By.xpath("//a[@href = '/SupportRegion/Create']")).click();
	
	  //String Name = sheet.getRow(1).getCell(1).getStringCellValue();     
	//driver.findElement(By.xpath("//input[@id = 'Name']")).sendKeys(Name);
	  
	  driver.findElement(By.xpath("//input[@id = 'Name']")).sendKeys("VirendraRegion");
	
	//String Email = sheet.getRow(1).getCell(2).getStringCellValue();
	//driver.findElement(By.xpath("//input[@id ='SupportEmail']")).sendKeys(Email);
	driver.findElement(By.xpath("//input[@id ='SupportEmail']")).sendKeys("virendra.rawat@travelport.com");
	
	driver.findElement(By.xpath("//input[@value = 'Create']")).submit();
	
}
	
	//edit region
	public void editregion(WebDriver mydriver) throws Exception
	{
		driver = mydriver;
		/*
		FileInputStream excelfile  = new FileInputStream("C:\\Data\\Selenium\\tc.xlsx");
		   @SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
		   XSSFSheet sheet = workbook.getSheetAt(4);
		  */
			Thread.sleep(1000);
		   driver.findElement(By.xpath("//th[@data-title = 'Name']//span[@class = 'k-icon k-filter']")).click();
		   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  

		   driver.findElement(By.xpath("//input[@data-bind = 'value:filters[0].value']")).click();
		   //driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		   driver.findElement(By.xpath("//input[@data-bind = 'value:filters[0].value']")).sendKeys("VirendraRegion");
		   driver.findElement(By.xpath("//input[@data-bind = 'value: filters[1].value']")).click();;
		   driver.findElement(By.xpath("//button[@type = 'submit']")).submit();
		   //driver.findElement(By.linkText("Details")).click();
		   Thread.sleep(1000);
		   driver.findElement(By.linkText("Edit")).click();
		   
		   //String editEmail = sheet.getRow(1).getCell(3).getStringCellValue();
		   driver.findElement(By.xpath("//input[@id ='SupportEmail']")).clear();
		   //driver.findElement(By.xpath("//input[@id ='SupportEmail']")).sendKeys(editEmail);
		   driver.findElement(By.xpath("//input[@id ='SupportEmail']")).sendKeys("Editemail@test.com");
		   
		   driver.findElement(By.xpath("//input[@value = 'Save']")).submit();
		  
	}
	
	//delete region
	public void deleteregion(WebDriver mydriver) throws Exception
	{
		driver = mydriver;
		/*
		FileInputStream excelfile  = new FileInputStream("C:\\Data\\Selenium\\tc.xlsx");
		   @SuppressWarnings("resource")
		   XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
		   XSSFSheet sheet = workbook.getSheetAt(4);
		  */
			Thread.sleep(1000);
		   driver.findElement(By.xpath("//th[@data-title = 'Name']//span[@class = 'k-icon k-filter']")).click();
		   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);		   
		   
		   driver.findElement(By.xpath("//input[@data-bind = 'value:filters[0].value']")).click();
		   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		   driver.findElement(By.xpath("//input[@data-bind = 'value:filters[0].value']")).sendKeys("VirendraRegion");
		   driver.findElement(By.xpath("//input[@data-bind = 'value: filters[1].value']")).click();
		   driver.findElement(By.xpath("//button[@type = 'submit']")).submit();
		   Thread.sleep(1000);
		   
		  driver.findElement(By.linkText("Delete")).click();
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  //New line add by Virendra
		   driver.findElement(By.xpath("//input[@value='Delete']")).click();		  
		   }

	

}
