package qccAutomation;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class TestNG_QCCDriverScript {
	
	WebDriver driver;
	
	@Test(priority = 0)
	public void loginQCC() throws Exception{
		
		launchBrowser launchbrowser = new launchBrowser();
		launchbrowser.OpenBrowser("http://10.7.247.181/");
		driver = launchBrowser.getDriver();
		
		//Login to the application
		Login_QCC loginQCC = new Login_QCC();
		loginQCC.QCC_Login(driver);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);	
			
	}
	
	@Test(priority = 1)
	public void AgencySetting() throws Exception{
		
		Agency Agency_Method = new Agency();
		Agency_Method.createAgency(driver);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		//Edit Agency
		Agency_Method.editAgency(driver);
		
	}
	
	
	@Test(priority = 2)
	public void AccessSetting () throws Exception{
		
		//Create Access Methods
		AccessMethod Access_Method = new AccessMethod();
		Access_Method.CreateAccess(driver);
				
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
		//Edit Access Method
		Access_Method.EditAccess(driver);			
		
	}
	
	@Test(priority = 3)
	public void UserSetting() throws Exception{
		
		//Create User
		User User_Method = new User();
		User_Method.CreateUser(driver);
				
		//Edit User
		User_Method.Edituser(driver);
				
		//Activate user
		User_Method.activateuser(driver);
				
		//Delete user
		User_Method.deleteuser(driver);
	}
	
	@Test(priority = 4)
	public void deleteAccess() throws Exception{
			
		//Create Access Methods
		AccessMethod Access_Method = new AccessMethod();
		Access_Method.DeleteAccess(driver);
				
				
	}
	
	@Test(priority = 5)
	public void deleteAgency() throws Exception{
		//Delete Agency
		Agency Agency_Method = new Agency();
		Agency_Method.deleteAgency(driver);
		
	}
	
	@Test(priority =6)
	public void RegionSetting() throws Exception{
		
		SupportRegions Region_Support = new SupportRegions();
		
		Region_Support.addregion(driver);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		Region_Support.editregion(driver);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		Region_Support.deleteregion(driver);
	}
	
}
