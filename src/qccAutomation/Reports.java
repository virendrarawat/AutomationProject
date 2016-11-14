package qccAutomation;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;

public class Reports {
	public static WebDriver driver;
	
	//generate activity report
		public void activityreport(WebDriver mydriver) throws Exception
		{
		driver = mydriver;
		FileInputStream excelfile  = new FileInputStream("C:\\QCCAutomationTestData\\Reports.xlsx");
		   @SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
		  XSSFSheet sheet = workbook.getSheetAt(0);		 
		   
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   driver.findElement(By.linkText("Reports")).click();
		   driver.findElement(By.linkText("Activity report")).click();
		   driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		   
		    for(int i = 1; i <= sheet.getLastRowNum(); i++)
		   {
		    String agencyID = sheet.getRow(i).getCell(0).getStringCellValue();
		   if(agencyID.equals("Yes"))
		   {
			   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			   driver.findElement(By.id("AllAgencies")).click();
			   
		   }
		   else
		   {
		   String agency = sheet.getRow(i).getCell(1).getStringCellValue();
		   Select s = new Select(driver.findElement(By.id("AgencyID")));
		   s.selectByVisibleText(agency);
		   
		   String pcc = sheet.getRow(i).getCell(2).getStringCellValue();
		   Select p = new Select(driver.findElement(By.id("PCC")));
		   p.selectByVisibleText(pcc);

		   }
		   String from = sheet.getRow(i).getCell(3).getStringCellValue();
		   driver.findElement(By.id("FromDate")).clear();
		   driver.findElement(By.id("FromDate")).sendKeys(from);
		   
		   String to = sheet.getRow(i).getCell(4).getStringCellValue();
		   driver.findElement(By.id("ToDate")).clear();
		   driver.findElement(By.id("ToDate")).sendKeys(to);
		  
		   driver.findElement(By.id("btnExportExccel")).submit();
		   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		   
		   
			
		  // String text = driver.findElement(By.xpath("//div[@class = 'alert alert-danger']")).getText();
		   
		   driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		   //System.out.println(text);
		   boolean x = driver.findElement(By.xpath("//div[@class = 'alert alert-danger']")).isDisplayed();
		   System.out.println(x);
		   if(x == true)
				   {
			   driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 driver.findElement(By.xpath("//button[@class = 'close']")).click();
				   }
		   else
		   {
		   Alert confirmationAlert = driver.switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.dismiss();
		   }
				   
		    
		   
		 //Execute Script To Download File.exe file to run AutoIt script. File location = E:\\AutoIT\\
		   Runtime.getRuntime().exec("C:\\eclipse\\AutoIT\\DownloadFile.exe");
			   
		   }
		   }  
		    
		   
		

		//generate performance report	 
		public void performancereport(WebDriver mydriver) throws Exception
		{
        driver = mydriver;
		FileInputStream excelfile  = new FileInputStream("C:\\QCCAutomationTestData\\Reports.xlsx");
		   @SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
		   XSSFSheet sheet = workbook.getSheetAt(1);
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   driver.findElement(By.linkText("Reports")).click();
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   driver.findElement(By.xpath("//a[@href = '/Report/DelayIndex']")).click();
		   
		   for(int i = 1; i <= sheet.getLastRowNum(); i++)
		   {
		   String gap = sheet.getRow(i).getCell(2).getStringCellValue();
		   if(gap.equals("Yes"));
		   	{
			   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			   driver.findElement(By.id("chkUnexpectedOnly")).click();}
		   	}
			String From = sheet.getRow(1).getCell(0).getRawValue();
			driver.findElement(By.id("dateSearchModel_CreatedDateTimeFrom")).clear();
			   driver.findElement(By.id("dateSearchModel_CreatedDateTimeFrom")).sendKeys(From);
			   
			   String To = sheet.getRow(1).getCell(1).getStringCellValue();
			   driver.findElement(By.id("dateSearchModel_CreatedDateTimeTo")).clear();
			   driver.findElement(By.id("dateSearchModel_CreatedDateTimeTo")).sendKeys(To);
			   
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 driver.findElement(By.linkText("//div[@class = 'editor-field']//button[@id = 'dateButton']")).click();
			 
	
		}   
}


		   
		   


