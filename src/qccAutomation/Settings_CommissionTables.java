package qccAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Settings_CommissionTables {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException, AWTException {
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
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
			
		//driver.findElement(By.xpath("//li[@class='dropdown active']//a[@class='dropdown-toggle']")).click();
		
		//driver.findElement(By.xpath("//a[contains(@href,'Region')]")).click();
		
		
		
		
		int TotalDropDown = driver.findElements(By.xpath("//a[@class='dropdown-toggle']")).size();
		
		System.out.println("Total Number of DropDown = " +TotalDropDown);
		
		for (int i=1;i<=TotalDropDown;i++){
			
			String DropdownName = driver.findElement(By.xpath("//a[@class='dropdown-toggle']["+i+"]")).getText();
			
			System.out.println("String Name = " +DropdownName);
			
			if (DropdownName.contains("Settings")){
				driver.findElement(By.xpath("//a[@class='dropdown-toggle']["+i+"]")).click();	
				driver.findElement(By.xpath("//a[contains(@href,'Region')]")).click();
				i=3;
				
			}
			
			
		}
			
		//Count number of rows in the name column
		int regioncount = driver.findElements(By.xpath("//td[@role='gridcell'][1]")).size();
		
		System.out.println("Name in the column = " +driver.findElement(By.xpath("//td[@role='gridcell'][1]")).getText());
		
		System.out.println("Number of region in the table = " +regioncount);
		
		//Navigate to the column to find the Region Name
		for (int i=1;i<=regioncount;i++){
			
			System.out.println("Name in the tables are = " +driver.findElement(By.xpath(".//*[@id='DefaultRegions']/table/tbody/tr["+i+"]/td[1]")).getText());
			
			String name = driver.findElement(By.xpath(".//*[@id='DefaultRegions']/table/tbody/tr["+i+"]/td[1]")).getText();
			
			//IF name found in first page then click countris button
			if (name.contains("Africa (230 - TC2)")){
				
				driver.findElement(By.xpath(".//*[@id='DefaultRegions']/table/tbody/tr["+i+"]/td[2]")).click();
				i=regioncount +1;
				
			}
			//If name not found in the first page then move to next page
			else
			{
				System.out.println("Inside else condition");
				if (i==regioncount){
					
					System.out.println("Inside if condition to click on second page");
					
					//determine the number of pages in the screen
					int numberofPage = driver.findElements(By.xpath("//ul[contains(@class,'k-pager-numbers k-reset')]//li//a[@class='k-link']")).size();
					
					System.out.println("Number of page in the table = " +numberofPage);
					
					for(int j=2;j<=numberofPage+1;j++){
						System.out.println("Inside for loop to click on second page");
						
						//Click button to navigate next page
						driver.findElement(By.xpath("//a[contains(text(),"+j+")]")).click();
						
						//driver.findElement(By.xpath("//ul[contains(@class,'k-pager-numbers k-reset')]//li//a[@class='k-link']["+j+"]")).click();						
						
						Thread.sleep(3000);
						
						//Count number of rows in the name column
						int namecount = driver.findElements(By.xpath("//td[@role='gridcell'][1]")).size();
						
						//System.out.println("Name in the column = " +driver.findElement(By.xpath("//td[@role='gridcell'][1]")).getText());
						
						System.out.println("Number of region in the table = " +namecount);
						
						
						//Navigate to the column to find the Region Name
						for (int x=1;x<=namecount;x++){
							
							driver.findElement(By.xpath(".//*[@id='DefaultRegions']/table/tbody/tr["+x+"]/td[1]")).click();
							System.out.println("Value of x = " +x);
							
							System.out.println("Name in the tables are = " +driver.findElement(By.xpath(".//*[@id='DefaultRegions']/table/tbody/tr["+x+"]/td[1]")).getText());
							
							String names = driver.findElement(By.xpath(".//*[@id='DefaultRegions']/table/tbody/tr["+x+"]/td[1]")).getText();
							
							
							//IF name found in first page then click countris button
							if (names.contains("Africa (230 - TC2)")){
								
								driver.findElement(By.xpath(".//*[@id='DefaultRegions']/table/tbody/tr["+x+"]/td[2]")).click();
								x=regioncount +1;
								j=numberofPage+2;
								
							}																
							
						}
					
				}
				
				}
			}	
				
		}
		
		
		
		
		
		
		/*
		int regioncount = driver.findElements(By.xpath("//td[@role='gridcell'][1]")).size();
		
		System.out.println("Name in the column = " +driver.findElement(By.xpath("//td[@role='gridcell'][1]")).getText());
		
		System.out.println("Number of region in the table = " +regioncount);
		
		for (int i=1;i<=regioncount;i++){
			
			System.out.println("Name in the tables are = " +driver.findElement(By.xpath(".//*[@id='DefaultRegions']/table/tbody/tr["+i+"]/td[1]")).getText());
			
			String name = driver.findElement(By.xpath(".//*[@id='DefaultRegions']/table/tbody/tr["+i+"]/td[1]")).getText();
			
			
			if (name.contains("VirendraAutomation")){
				
				driver.findElement(By.xpath(".//*[@id='DefaultRegions']/table/tbody/tr["+i+"]/td[2]")).click();
				i=regioncount +1;
				
			}
			else
			{
				if (i==regioncount){
				driver.findElement(By.xpath("//a[contains(@title,'last page')]//span[contains(@class,'seek-e')]")).click();
				
				Thread.sleep(500);
				
				int lastregioncount = driver.findElements(By.xpath("//td[@role='gridcell'][1]")).size();
				
				System.out.println("Name in the column = " +driver.findElement(By.xpath("//td[@role='gridcell'][1]")).getText());
				
				System.out.println("Number of region in the table = " +lastregioncount);
				
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				
				for (int j=1;j<=lastregioncount;j++){
					
					System.out.println("Name in the tables are = " +driver.findElement(By.xpath(".//*[@id='DefaultRegions']/table/tbody/tr["+j+"]/td[1]")).getText());
					
					String lastname = driver.findElement(By.xpath(".//*[@id='DefaultRegions']/table/tbody/tr["+j+"]/td[1]")).getText();
					
					
					if (lastname.contains("VirendraAutomation")){
						
						driver.findElement(By.xpath(".//*[@id='DefaultRegions']/table/tbody/tr["+j+"]/td[3]")).click();
						Robot r = new Robot();
						r.keyPress(KeyEvent.VK_ENTER);
						r.keyRelease(KeyEvent.VK_ENTER);
						
						j=lastregioncount +1;
						
					}
					else
					{
						System.out.println("Name not found in the table");
					}
					}
				
				
				
				}
			}
		}
	
	*/	
		
		}
	}
	

/*
Edit Button
.//*[@id='DefaultRegions']/table/tbody/tr[1]/td[3]/a[1]

Delete Button
.//*[@id='DefaultRegions']/table/tbody/tr[1]/td[3]/a[2]

*/

//int NumberofColoumn = driver.findElements(By.xpath("//table[@role='grid']//thead[@class='k-grid-header']//tr//th[@scope='col']")).size();

//System.out.println("Number of column in the table = " +NumberofColoumn)


