package testscripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtility;

public class Base {

public WebDriver driver;  //declared globally
	public ScreenshotUtility screenshotutility;
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver =new ChromeDriver();

		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			driver =new EdgeDriver();

		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			driver =new FirefoxDriver();

		}
		else 
		{
			throw new Exception("Browser is not correct");
		}
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Global:Applicable for the entire framework
		
		driver.manage().window().maximize();//maximize chyn
		
	}
	@AfterMethod(alwaysRun = true)
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			screenshotutility = new ScreenshotUtility();
			screenshotutility.getScreenShot(driver, iTestResult.getName());
		}

		driver.quit();
	}
}