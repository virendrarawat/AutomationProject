package qccAutomation;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class launchBrowser {

	private static WebDriver driver = null;

	public static WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String ScriptDriver) {
		
		if (ScriptDriver == "chrome"){
			
			System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\chromedriver.exe");
	        driver = new ChromeDriver();	
		}
		
		if (ScriptDriver == "FireFox"){	
			System.setProperty("webdriver.firefox.marionette","C:\\geckodriver\\geckodriver.exe");
			
			driver = new FirefoxDriver();		
		}	
		
		if (ScriptDriver == "IE"){	
			System.setProperty("webdriver.firefox.marionette","C:\\geckodriver\\geckodriver.exe");
			//test 
			//test1
			//test3
			//driver = new FirefoxDriver();		
		}	
	}

	public void OpenBrowser(String autUrl) {
		setDriver("FireFox");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(autUrl);
		System.out.println("QCC Application launched Successfully");
	}

}
