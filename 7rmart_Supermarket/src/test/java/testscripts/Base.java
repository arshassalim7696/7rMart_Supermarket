package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ConstantsFile;
import utilities.ScreenshotUtility;

public class Base {

public WebDriver driver;  //declared globally
	public ScreenshotUtility screenshotutility;
	public Properties prop;
	FileInputStream fs;
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception
	{
		try 
		{
			prop = new Properties();
			fs = new FileInputStream(ConstantsFile.CONFIGFILE);
			prop.load(fs);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
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
		driver.get(prop.getProperty("url"));
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