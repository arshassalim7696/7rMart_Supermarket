package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
		js.executeScript("window.scrollBy(0," + pixels + ")", " ");//scroll down 
	 }
	 public void pageScrollUp(JavascriptExecutor driver,int pixels)
	 {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-" + pixels + ")", " ");//scroll up
		
	 }
	 
}

