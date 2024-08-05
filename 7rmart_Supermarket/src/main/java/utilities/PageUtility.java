package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	 public void selectValueUsingSelectByVisibleText(WebElement dropdown,String VisibleText)
	 {
		 
		Select select=new Select(dropdown);
		select.selectByVisibleText(VisibleText);
	 }
	 public void selectValueUsingSelectByIndexValue(WebElement dropdown,int index)
	 {
		Select select=new Select(dropdown);
		select.selectByIndex(index);
	 }
	 
	 public void selectValueUsingSelectByValue(WebElement dropdown,String Value)
	 {
		Select select=new Select(dropdown);
		select.selectByValue(Value);
	 }
	 public void pageScrollDown(JavascriptExecutor driver,int pixels)
	 {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixels + ")", " ");
	 }
	 public void pageScrollUp(JavascriptExecutor driver,int pixels)
	 {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-" + pixels + ")", " ");
		
	 }
	 public void dragAndDropElements(WebDriver driver, WebElement sourceElement, WebElement targetElement)
	 {
	 	
	     Actions actions=new Actions(driver);
	     actions.dragAndDrop(sourceElement, targetElement).build().perform();

	 }

	 public void moveToElement(WebDriver driver, WebElement element)
	 {
	 	
	     Actions actions=new Actions(driver);
	     actions.moveToElement(element).build().perform();

	 }
	 public void mouseActionToDoubleClick(WebDriver driver, WebElement element)
	 {
	 	
	     Actions actions=new Actions(driver);
	     actions.doubleClick(element).build().perform();

	 }
	 public void mouseActionToContextClick(WebDriver driver, WebElement element)
	 {
	 	
	     Actions actions=new Actions(driver);
	     actions.contextClick(element).build().perform();

	 }
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

