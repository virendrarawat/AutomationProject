package qccAutomation;


import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import org.openqa.selenium.support.ui.Select;

public class Agency
{	
	public static WebDriver driver;
	public void createAgency(WebDriver mydriver) throws Exception
	{
		driver = mydriver;
		FileInputStream excelfile  = new FileInputStream("C:\\Users\\virendra.rawat\\Documents\\tc.xlsx");
		   @SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
		   XSSFSheet sheet = workbook.getSheetAt(2);
		   
		   driver.findElement(By.xpath("//a[@href = '/Agency']")).click();
		   driver.findElement(By.xpath("//a[@href = '/Agency/Create']")).click();
   
    String name = sheet.getRow(1).getCell(1).getStringCellValue();                                           
    driver.findElement(By.id("Name")).sendKeys(name);
    
    String timezone = sheet.getRow(1).getCell(2).getStringCellValue();
    driver.findElement(By.xpath("//label[@for = 'TimeZone']")).sendKeys(timezone);
      
    String country = sheet.getRow(1).getCell(3).getStringCellValue();
    driver.findElement(By.id("Country")).sendKeys(country);
    
    String pcc = sheet.getRow(1).getCell(4).getStringCellValue();
    driver.findElement(By.id("MasterPCC")).sendKeys(pcc);
    
    driver.findElement(By.id("agencyAssignedHandlers20")).click();
    driver.findElement(By.xpath("//input[@type = 'submit']")).submit();
	}
	
  public void editAgency(WebDriver mydriver) throws Exception
  {

	  driver = mydriver;
		FileInputStream excelfile  = new FileInputStream("C:\\Users\\virendra.rawat\\Documents\\tc.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
		   XSSFSheet sheet = workbook.getSheetAt(2);
		   driver.findElement(By.xpath("//a[@href = '/Agency']")).click();
		   driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		   Thread.sleep(1000);
  driver.findElement(By.xpath("//th[@data-title = 'Name']//span[@class = 'k-icon k-filter']")).click();
  
  String name = sheet.getRow(1).getCell(1).getStringCellValue();
  System.out.println("Agency Name in Edit Method = " +name);
  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
  /*
  WebElement element = driver.findElement(By.xpath("//input[contains(@data-bind, 'filters[0]')]"));
  JavascriptExecutor executor = (JavascriptExecutor)driver;
  executor.executeScript("arguments[0].value = '"+name+"';",element);
	*/
	
	driver.findElement(By.xpath("//input[contains(@data-bind, 'filters[0]')]")).click();
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
  driver.findElement(By.xpath("//input[contains(@data-bind, 'filters[0]')]")).sendKeys(name);
  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
  driver.findElement(By.xpath("//input[contains(@data-bind, 'filters[1]')]")).click();
  
  
  driver.findElement(By.xpath("//button[@type = 'submit']")).submit();
  Thread.sleep(1000);
  driver.findElement(By.xpath("//a[contains(@href,'/Agency/Detail')]")).click();
  driver.findElement(By.xpath("//a[contains(@href,'/Agency/Edit/')]")).click();
  
  //double failqueue = sheet.getRow(1).getCell(5).getNumericCellValue();
  //System.out.println(failqueue);
  driver.findElement(By.id("DefaultFailureQueueNumber")).clear();
  driver.findElement(By.id("DefaultFailureQueueNumber")).sendKeys("98");
  
  String failpcc = sheet.getRow(1).getCell(6).getStringCellValue();
  driver.findElement(By.id("DefaultFailureQueuePcc")).clear();
 driver.findElement(By.id("DefaultFailureQueuePcc")).sendKeys(failpcc);
  driver.findElement(By.xpath("//input[contains(@value, 'Save')]")).click();
  workbook.close();
 }
  
  public void deleteAgency(WebDriver mydriver) throws Exception
  {
	  driver = mydriver;
	  driver = mydriver;
		FileInputStream excelfile  = new FileInputStream("C:\\Users\\virendra.rawat\\Documents\\tc.xlsx");
		   XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
		   XSSFSheet sheet = workbook.getSheetAt(2);
		   driver.findElement(By.xpath("//a[@href = '/Agency']")).click();
		   driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		   Thread.sleep(1000);
		   driver.findElement(By.xpath("//th[@data-title = 'Name']//span[@class = 'k-icon k-filter']")).click();
	  String name = sheet.getRow(1).getCell(1).getStringCellValue();                    
	  System.out.println("Agency Name in Delete Method = " +name);
	  /*
	  WebElement element = driver.findElement(By.xpath("//input[contains(@data-bind, 'filters[0]')]"));
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",element);
	  executor.executeScript("arguments[0].value = '"+name+"';",element);
	  */
	  
	  driver.findElement(By.xpath("//input[contains(@data-bind, 'filters[0]')]")).click();
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[contains(@data-bind, 'filters[0]')]")).sendKeys(name);
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[contains(@data-bind, 'filters[1]')]")).click();
	  
	  driver.findElement(By.xpath("//div//button[@type = 'submit']")).submit();
	  Thread.sleep(1000);
	  //driver.findElement(By.xpath("//a[@class = 'btn btn-warning']")).click();
	  driver.findElement(By.xpath("//a[contains(@href,'/Agency/Detail')]")).click();
	  driver.findElement(By.xpath("//a[contains(@href, 'Delete')]")).click();
	  driver.findElement(By.xpath("//input[contains(@value, 'Delete')]")).click();
	  
	 workbook.close();
  }
}

