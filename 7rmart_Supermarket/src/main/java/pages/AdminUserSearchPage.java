package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.ActionUtility;
import utilities.PageUtility;

public class AdminUserSearchPage {
public WebDriver driver ;//can acces in multiple action methods //driver is class variable 
	
	//constructor
	public AdminUserSearchPage(WebDriver driver)//constructor will initiate  the webdriver//driver local variable
	{
	 this.driver=driver;//name of local &class variable is same so we use this keywrd
	 PageFactory.initElements(driver,this);
	}
	//Locators

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement adminUsersmoreinfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement searchButton;
	@FindBy(xpath="//input[@id='un']")WebElement userNameSearch;
	@FindBy(xpath="//select[@id='ut']")WebElement dropdownSelectUserType;
	@FindBy(xpath="//button[@name='Search']")WebElement submitSearchButton;
	@FindBy(xpath="//tbody//descendant::td[1]")List<WebElement> tdUserName;
	@FindBy(xpath="//button[@name='Search']")WebElement resetButton;


	public AdminUserSearchPage clickOnMoreInfoButton()
	{
		adminUsersmoreinfo.click();
		return this;
	} 
	public AdminUserSearchPage clickOnSearchButton()
	{
		searchButton.click();
		return this;
	} 
	
	public AdminUserSearchPage enterAdminUsernameOnUsernameField(String ExistingUsernameSendkeys)
	{
		userNameSearch.sendKeys(ExistingUsernameSendkeys);
		return this;
	}
	public AdminUserSearchPage selectuserTypeFromDropDown(String VisibleText)
	{
		PageUtility pageutility=new PageUtility();
		pageutility.selectValueUsingSelectByVisibleText(dropdownSelectUserType,VisibleText);
		return this;
	}
	/*public AdminUserSearchPage performingMouseActionToContextClick(WebDriver element )
	{
		ActionUtility actionutility=new ActionUtility();
		actionutility.mouseActionToContextClick(element);
		return this;
	}*/
	public AdminUserSearchPage clickOnSubmitSearchButton()
	{
		submitSearchButton.click();
		return this;
	} 
	
	public boolean verifySearchedUserIsAvailableOrNotInTableList()
	{
		boolean flag=false;
		for(WebElement tdname:tdUserName)
		 {
			 String textname=tdname.getText();
			 if(textname.equals("Ramuram"))
				{
					flag=true;				
				}
		 }
		return flag;
	}
	public AdminUserSearchPage clickOnResetButton()
	{
		resetButton.click();
		return this;
	} 
	public boolean verifyResetIsSuccesOrNot()
	{
		boolean resetStatus=resetButton.isEnabled();
		return resetStatus;
	}
	public AdminUserSearchPage scrollDownAdminUserSearchPage(int pixels)
	{
		PageUtility pageutility=new PageUtility();
		pageutility.pageScrollDown((JavascriptExecutor) driver,pixels);
		return this;
	}
	public AdminUserSearchPage scrollUpAdminUserSearchPage(int pixels)
	{
		PageUtility pageutility=new PageUtility();
		pageutility.pageScrollUp((JavascriptExecutor) driver,pixels);
		return this;
	}
}
