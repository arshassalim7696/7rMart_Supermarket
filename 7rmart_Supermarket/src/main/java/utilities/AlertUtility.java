package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertUtility {
	 public String getAlertText(WebDriver driver,WebElement element) {
		 String alertText=driver.switchTo().alert().getText();
		 return alertText;
	 }
	 
	 public void acceptAlert(WebDriver driver,WebElement element) {
		 driver.switchTo().alert().accept();
	 }
	 
	 public void dismissAlert(WebDriver driver,WebElement element) {
		 driver.switchTo().alert().dismiss();
	 }
	 
	 public void enterMessageInAlert(WebDriver driver,WebElement element,String enterMessage) {
		 driver.switchTo().alert().sendKeys(enterMessage);	
		    driver.switchTo().alert().accept();
	 }
}
