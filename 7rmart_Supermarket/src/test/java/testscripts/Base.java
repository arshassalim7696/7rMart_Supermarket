package testscripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

public WebDriver driver;  //declared globally
	
	@BeforeMethod
	public void initializeBrowser()
	{
		driver =new ChromeDriver();//chrome browser load akan
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Global:Applicable for the entire framework
		
		driver.manage().window().maximize();//maximize chyn
		
	}
	@AfterMethod
	public void driverQuit()   //Separate method to close all tabs and session terminates 
	{
	driver.quit();	
	}
	
}