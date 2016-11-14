package qccAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CriteriaSetting {
	
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//launch Browser and Application
		launchBrowser launchbrowser = new launchBrowser();
		launchbrowser.OpenBrowser("http://10.7.247.181/");
		driver = launchBrowser.getDriver();
		
		
		//Login to the application
		Login_QCC loginQCC = new Login_QCC();
		loginQCC.QCC_Login(driver);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		/*
		//Create Agency
		Agency Agency_Method = new Agency();
		Agency_Method.createAgency(driver);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		*/
		
		driver.findElement(By.xpath("//a[@href = '/Schedule']")).click();
		
		driver.findElement(By.xpath("//th[@data-title='Name']//span[@class='k-icon k-filter']")).click();
		
		driver.findElement(By.xpath("//input[contains(@data-bind, 'filters[0]')]")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[contains(@data-bind, 'filters[0]')]")).sendKeys("Test Farhad");
	  
	  
	  driver.findElement(By.xpath("//button[@type = 'submit']")).submit();
	  
	  
	  
	  driver.findElement(By.xpath("//a[contains(@href,'/Schedule/Details/')]")).click();
	  
	  
	  
	  driver.findElement(By.xpath("//a[contains(@href,'/Schedule/ActionDetails/')]")).click();
	  
	  
	//Click Edit Criteria button
			driver.findElement(By.xpath("//a[contains(@href,'/Criteria/Create/')]")).click();
			
			
			driver.findElement(By.name("ShowCriteriaFilters")).click();
			
		
		/*
		 
		 //Create Schedule
		 
		driver.findElement(By.xpath("//a[contains(@href,'Create')]")).click();
		
		Select aselect = new Select(driver.findElement(By.id("AgencyId")));
		aselect.selectByVisibleText("Automation1");
		
		driver.findElement(By.name("Name")).sendKeys("Automation");
		
		driver.findElement(By.name("ScheduleIsActive")).click();
		
		driver.findElement(By.xpath("//input[@value='Create']")).click();
		
		driver.findElement(By.xpath("//a[contains(@href,'Details')]")).click();
		
		driver.findElement(By.xpath("//a[contains(@href,'/Schedule/ActionCreate/')]")).click();
		
		driver.findElement(By.id("Name")).sendKeys("Automation");
		
		
		//Click Edit Criteria button
		driver.findElement(By.xpath("//a[contains(@href,'/Criteria/Create/')]")).click();
		
		
		driver.findElement(By.name("ShowCriteriaFilters")).click();
		
		
		
		
		//Click Add new item button
		//driver.findElement(By.xpath("//a[contains(@class,'k-grid-add')]")).click();
		*/
		
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
	


