package AutomationFramework;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
import java.util.concurrent.TimeUnit;




//import org.apache.bcel.verifier.statics.IntList;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.*;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;

//import java.util.List;
//import java.util.Set;

//import javax.swing.text.html.HTMLDocument.Iterator;


public class HotelBooking {

	
private static WebDriver driver = null;
	


//public void CreateHotelBooking(WebDriver myDirver){
	
	public static void main(String[] args) {
		// Create a new instance of the Firefox driver
		
		System.setProperty("webdriver.firefox.marionette","C:\\geckodriver\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		//driver = myDirver;
	
		driver.get("https://uat.axess-btm.com");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("jal_traveller@locomote.com.au");

		// Find the element that's ID attribute is 'pwd' (Password)

		// Enter Password on the element found by the above desc.

		driver.findElement(By.id("password")).sendKeys("loco3000");

		// Now submit the form. WebDriver will find the form for us from the
		// element

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		// Navigate to My Trips Screen
		driver.findElement(By.linkText("My Trips")).click();

		// Navigate to Book Screen
		driver.findElement(By.linkText("Book")).click();
		
		
		//Close Air Search booking
		driver.findElement(By.xpath("//a[contains(@class, 'cancel')]")).click();
		
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//driver.findElements(By.xpath("//a[contains(@class, 'btn btn-default btn-block')]")).size();
			
	
		
		//Click Add Hotel Button
		driver.findElement(By.xpath("//a[contains(@class, 'add hotel')]")).click();
		
		driver.findElement(By.xpath("//div[@class = 'city-name']//input[contains(@class, 'city tt-input')]")).clear();
		
		driver.findElement(By.xpath("//div[@class = 'city-name']//input[contains(@class, 'city tt-input')]")).sendKeys("SYD");
		
		driver.findElement(By.xpath("//div[@class = 'city-name']//input[contains(@class, 'city tt-input')]")).sendKeys(Keys.TAB);
		
		driver.findElement(By.xpath("//input[@name = 'startDate']")).clear();
		
		driver.findElement(By.xpath("//input[@name = 'startDate']")).sendKeys("04-09-2016");
		
		driver.findElement(By.xpath("//input[@name = 'maxRate']")).click();
		
		
		driver.findElement(By.xpath("//input[@name = 'endDate']")).clear();
		
		driver.findElement(By.xpath("//input[@name = 'endDate']")).sendKeys("05-09-2016");
		
		driver.findElement(By.xpath("//input[@name = 'maxRate']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click Search Button
		driver.findElement(By.xpath("//button[contains(@class, 'search-action')]")).click();
		
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		

			
		//List<WebElement> list = (List<WebElement>) driver.findElement(By.xpath("//div[@class = 'hotels']//div[@class = 'hotels-list']//div[contains(@class = 'hotel results-row vcard')]"));
		
		//System.out.println(list.size());
		
		
		//for(int i =1; i<=5;i++)
		//{	
			
		int TotalHotel = driver.findElements(By.xpath("//div[contains(@class, 'hotel-desc')]//div[contains(@class, 'hotel-name')]")).size();
		
		System.out.println("Total hotel in the Serach Result are" +TotalHotel);	
		 
		
			
		
		for (int i=1;i<=TotalHotel;i++)
		{
			
			String HotelName = driver.findElement(By.xpath("(//div[contains(@class, 'hotel-desc')]//div[contains(@class, 'hotel-name')])["+i+"]")).getText();
			
			System.out.println(HotelName);			
			
			
			if (HotelName.contains("Holiday"))
			{
				
				driver.findElement(By.xpath("(//div[contains(@class, 'hotel-desc')]//div[contains(@class, 'hotel-name')])["+i+"]")).click();
				
				int RateType = driver.findElements(By.xpath("//td[contains(@class,'hotel-rates-info')]//div[contains(@class,'hotel-rates-title')]")).size();
				System.out.println(RateType);
				
				for (int j = 1;j<=RateType;j++)
				{
					String RateTypeDescription = driver.findElement(By.xpath("(//td[contains(@class,'hotel-rates-info')]//div[contains(@class,'hotel-rates-title')])["+j+"]")).getText();
					System.out.println(RateTypeDescription);				
					
					if (RateTypeDescription.contains("Best flexible rate"))
					 {	
					   driver.findElement(By.xpath("(//td[contains(@class, 'hotel-rates-rate')]//a[@class = 'select-rate']//div[@class = 'converted-rate'])["+j+"]")).click();
					   j=RateType+1;
					   
					   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					   
						if (driver.findElements(By.xpath("//select[@name='reason']"))
								.isEmpty() == false) {
						
							Select failedReasonDropDown = new Select(
									driver.findElement(By
											.xpath("//select[@name='reason']")));
							failedReasonDropDown.selectByVisibleText("Conference");

						} else {
							System.out.println("reason not displayed***************");
						}
						
						
						driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
						
						
						//driver.findElement(By.xpath("//button[contains(@class, 'continue')]")).click();
						
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						int ContButtonSize = driver.findElements(By.xpath("//*[@id='bookings']/div/div[3]/div[2]/ul/li[1]/button")).size();
						
						System.out.println("No of continue button in screen = "+ContButtonSize);
																		
						
						String ButtonName = driver.findElement(By.xpath("//button[contains(@class, 'continue')]")).getText();
						
						System.out.println(ButtonName);
						
						//String ButtonPath = "//button[contains(@class, 'continue')]";
						
						
						WebElement element = driver.findElement(By.xpath("//button[contains(@class, 'continue')]"));
						JavascriptExecutor executor = (JavascriptExecutor)driver;
						executor.executeScript("arguments[0].click();", element);
						
																	
						//clickAnElementByLinkText(ButtonPath);
						
						System.out.println("Clicked Continue Button");
						
						
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						
						driver.findElement(
								By.xpath("//div[@class = 'payment-options-select']//div[@class = 'chosen-container chosen-container-single']//a[@class = 'chosen-single chosen-default']")).click();
						
						
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.findElement(By.xpath("//li[contains(.,'TestAuto')]")).click();
						

				driver.findElement(By.xpath("//input[@type = 'checkbox']"))
						.click();
				
		        
				driver.findElement(
						By.xpath("//button[contains(@class, 'complete-booking')]"))
						.click();
				
				
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				
				String PNR = driver.findElement(
						By.xpath("//div[contains(@class, 'alert')]//p//a[contains(@class, 'view-trip')]")).getText();

				System.out.println(PNR);
				
				// Navigate to Booking Screen
				driver.findElement(By.linkText("New Trip")).click();
					   
					 }					
					

					i = TotalHotel + 1;
					
				}	
			}	
			
				
		}	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
				
		}


public static void clickAnElementByLinkText(String ElementPath) {
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)					
			       .withTimeout(90, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);
		
		System.out.println(ElementPath);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementPath)));
		
	    driver.findElement(By.xpath(ElementPath)).click();
					
	}

}
