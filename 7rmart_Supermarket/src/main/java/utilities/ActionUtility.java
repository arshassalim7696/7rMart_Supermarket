package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtility {

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
}