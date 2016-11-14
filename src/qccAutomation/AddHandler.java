package qccAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddHandler {

	private static WebDriver driver = null;
	
	public static void main(String[] args) throws IOException, AWTException{
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.firefox.marionette","C:\\geckodriver\\geckodriver.exe");
		
				driver = new FirefoxDriver();
				
				driver.manage().window().maximize();
			
				driver.get("http://10.7.247.181/");
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElement(By.id("loginLink")).click();
				
				driver.findElement(By.id("UserName")).sendKeys("virendra.rawat@travelport.com");
							
				driver.findElement(By.id("Password")).sendKeys("Travelport1");
				
				driver.findElement(By.xpath("//input[contains(@class, 'btn btn-primary')]")).click();
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			
								
				driver.findElement(By.xpath("//a[contains(@href,'Handler')]")).click();
				
				driver.findElement(By.xpath("//p//a[contains(@href,'Create')]")).click();
				
				String AvailableforAllAgencies = "Yes";
				
				if (AvailableforAllAgencies == "Yes"){
				
					//Click Available for all agencies check box
					driver.findElement(By.xpath("//input[@id = 'availableForAllCustomers']")).click();
				}
				else{
					//select agencies
					driver.findElement(By.xpath("//div[contains(@class, 'multiselect-wrap')]")).click();
									
					List<WebElement> agency = driver.findElements(By.xpath("//ul[contains(@id,'AgencyMultiSelect_listbox')]//li[@class='k-item']"));
					
					for (WebElement opt : agency) {
						//System.out.println(opt.getText());
			            if (opt.getText().equals("1P Test")) {
			                opt.click();
			                }
			        }
					
				}
				
								
				driver.findElement(By.xpath("//input[contains(@name,'assemblyFile')]")).click();
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				String filepath = "C:\\Users\\virendra.rawat\\Documents\\QCC_Automation.zip"; 
				setClipboardData(filepath);
				 
				try {
					 Robot robot = new Robot();
					 robot.delay(1000);
					 robot.keyPress(KeyEvent.VK_CONTROL);
			            robot.keyPress(KeyEvent.VK_V);
			            robot.keyRelease(KeyEvent.VK_V);
			            robot.keyRelease(KeyEvent.VK_CONTROL);
			            robot.keyPress(KeyEvent.VK_ENTER);
			            robot.keyRelease(KeyEvent.VK_ENTER);
			            robot.delay(1000);
					    
					      } catch (AWTException e) {
					        e.printStackTrace();
					      }
								
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//Enter Contact Name
				driver.findElement(By.xpath("//input[@name = 'ContactName']")).sendKeys("Virendra");
				
				//Enter Contact Email
				driver.findElement(By.xpath("//input[@name = 'ContactEmail']")).sendKeys("virendra.rawat@travelport.com");
				
				
				int Apitypes = driver.findElements(By.xpath("//input[@name = 'ApiTypes']")).size();
				
				//select all API types check boxes
				for (int i = 1;i<=Apitypes;i++)
				{
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
										
					WebElement element = driver.findElement(By.xpath("//input[@name = 'ApiTypes']["+i+"]"));
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", element);
					
					
				}
				
				int runBaseQueue = driver.findElements(By.xpath("//input[@name = 'RunBasedOnQueues']")).size();
				
				//select all API types check boxes
				for (int i = 1;i<=runBaseQueue;i++)
				{
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					//driver.findElement(By.xpath("(//input[@name = 'RunBasedOnQueues']["+i+"])")).click();
					
					WebElement element = driver.findElement(By.xpath("//input[@name = 'RunBasedOnQueues']["+i+"]"));
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", element);
					
				}
				
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//Click Create button
				//driver.findElement(By.xpath("//input[@value = 'Create']")).click();
				
				WebElement element = driver.findElement(By.xpath("//input[@value = 'Create']"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
				
				
						
	}
public static void setClipboardData(String string) {
    StringSelection stringSelection = new StringSelection(string);
    Toolkit.getDefaultToolkit().getSystemClipboard()
             .setContents(stringSelection, null);
 }
}