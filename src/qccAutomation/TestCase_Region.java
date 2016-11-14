package qccAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class TestCase_Region {
	
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
				
				SupportRegions Region_Support = new SupportRegions();
				
				Region_Support.addregion(driver);
				
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				
				Region_Support.editregion(driver);
				
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				
				Region_Support.deleteregion(driver);
				
			
				
				
				
				
	}

}
