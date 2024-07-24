package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long EXPLICITWAIT=10;
	public static final long IMPLICITWAIT=10;
	public void clickbleWait(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void invisibilityOfElementWait(WebDriver driver, WebElement element ) 
    {
   	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICITWAIT));
   	 wait.until(ExpectedConditions.invisibilityOf(element));
   	}
	
	public void titleContainsWait(WebDriver driver, String element ) 
    {
      	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICITWAIT));
      	 wait.until(ExpectedConditions.titleContains(element));
    } 
	public void elementToBeSelectedWait(WebDriver driver, WebElement element ) 
    {
   	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICITWAIT));
   	 wait.until(ExpectedConditions.elementToBeSelected(element));
   	}
	 
	   
	 public void alertPresentFluentWait(WebDriver driver, String element)
	    {
	    	 Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	 	            .withTimeout(Duration.ofSeconds(30))
	 	            .pollingEvery(Duration.ofSeconds(5))
	 	            .ignoring(NoSuchElementException.class);
	 	    fluentWait.until(ExpectedConditions.alertIsPresent());
	    }
	 public void elementToBeSelectedFluentWait(WebDriver driver, WebElement element)
	    {
	    	 Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	 	            .withTimeout(Duration.ofSeconds(30))
	 	            .pollingEvery(Duration.ofSeconds(5))
	 	            .ignoring(NoSuchElementException.class);
	 	    fluentWait.until(ExpectedConditions.elementToBeSelected(element));
	    }
	 public void visibilityOfElementFluentWait(WebDriver driver, WebElement element)
	    {
	    	 Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	 	            .withTimeout(Duration.ofSeconds(30))
	 	            .pollingEvery(Duration.ofSeconds(5))
	 	            .ignoring(NoSuchElementException.class);
	 	    fluentWait.until(ExpectedConditions.visibilityOf(element));
	    }
	
	   
}
 
