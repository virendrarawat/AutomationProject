package qccAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestCase_Login {

	public static WebDriver driver;
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//launch Browser and Application
		launchBrowser launchbrowser = new launchBrowser();
		launchbrowser.OpenBrowser("http://10.7.247.181/");
		driver = launchBrowser.getDriver();
		
	
		
		
		//click button
		Clickbutton ClickanyButton = new Clickbutton()
		ClickanyButton.button(driver,xpath);
		
		
		
		//Login to the application
		Login_QCC loginQCC = new Login_QCC();
		loginQCC.QCC_Login(driver);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		
		//Create Agency
		Agency Agency_Method = new Agency();
		Agency_Method.createAgency(driver);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		//Edit Agency
		Agency_Method.editAgency(driver);
		
		//Create Access Methods
		AccessMethod Access_Method = new AccessMethod();
		Access_Method.CreateAccess(driver);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		//Edit Access Method
		Access_Method.EditAccess(driver);		
						
		//Create User
		User User_Method = new User();
		User_Method.CreateUser(driver);
		
		//Edit User
		User_Method.Edituser(driver);
		
		//Activate user
		User_Method.activateuser(driver);
		
		//Delete user
		User_Method.deleteuser(driver);
		
		//Delete Access Method
		Access_Method.DeleteAccess(driver);
		
		//Delete Agency
		Agency_Method.deleteAgency(driver);
		
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		
		SupportRegions Region_Support = new SupportRegions();
		//Add Regions
		Region_Support.addregion(driver);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//Edit Regions
		Region_Support.editregion(driver);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//Delete Regions
		Region_Support.deleteregion(driver);
		
		
		/*
		Agency Agency_Method = new Agency();
		Agency_Method.createAgency(driver);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		Agency_Method.editAgency(driver);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		Agency_Method.deleteAgency(driver);
		*/
		
		/*
		AccessMethod Access_Method = new AccessMethod();
		Access_Method.CreateAccess(driver);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		Access_Method.EditAccess(driver);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		Access_Method.DeleteAccess(driver);
		*/
		
		/*driver.findElement(By.xpath("//a[contains(@href,'Agency')]")).click();
		int i = 82;
		driver.findElement(By.xpath("//a[contains(@href, '/Agency/Detail/"+i+"')]")).click();
		*/
		
		/*
		driver.findElement(By.xpath("//a[@href = '/User']")).click();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.findElement(By.xpath("//th[@data-title = 'Email Address']//span[@class = 'k-icon k-filter']")).click();
	      //String Emailadd = sheet.getRow(4).getCell(1).getStringCellValue();   
	      
	      driver.findElement(By.xpath("//input[@data-bind = 'value:filters[0].value']")).click();
	      driver.findElement(By.xpath("//input[@data-bind = 'value:filters[0].value']")).sendKeys("virendra.rawat@travelport.com");
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      driver.findElement(By.xpath("//input[@data-bind = 'value: filters[1].value']")).click();
	      
	      driver.findElement(By.xpath("//button[@type = 'submit']")).click();
	    
	      driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	      Thread.sleep(500);
	     
	      driver.findElement(By.xpath("//td[@role = 'gridcell']//a[contains(@href,'Edit')]")).click();
	      */
		
	      /*
	      WebElement element = driver.findElement(By.xpath("//a[contains(@href,'Edit')]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			*/
			
	     // driver.findElement(By.xpath("//a[contains(@href,'Edit')]")).click();
	      
	      /*
	      int numberofbuttons = driver.findElements(By.xpath("//a[@class = 'k-button']")).size();
	      
	      System.out.println("Number of buttons in the screen = " +numberofbuttons);
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      for (int i=1;i<=numberofbuttons;i++){
	    	  String ButtonName = driver.findElement(By.xpath("//a[@class = 'k-button']")).getText();
	    	  System.out.println("Button name is = " +ButtonName);
	    	  
	    	  //if (ButtonName.contains("edit")){
	    		  
	    		  driver.findElement(By.xpath("//td[@role = 'gridcell']//a[contains(@href,'Edit')]")).click();
	    		//  return;
	    		  	    		  
	    	  //}
	    	  	    	  
	      }
	      
	     
	      */
	     
	     /*
	    driver.findElement(By.id("RoleName")).sendKeys("AgencyUser");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
*/
	    

	}

}
