package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {

	public WebDriver driver ;//can acces in multiple action methods //driver is class variable 
	
	//constructor
	public AdminUsersPage(WebDriver driver)//constructor will initiate  the webdriver//driver local variable
	{
	 this.driver=driver;//name of local &class variable is same so we use this keywrd
	 PageFactory.initElements(driver,this);
	}
	//Locators
	
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement adminUsersmoreinfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newButton;
	@FindBy(xpath="//input[@id='username']")WebElement addNewUsername;
	@FindBy(xpath="//input[@id='password']")WebElement addPassword;
	@FindBy(xpath="//select[@id='user_type']")WebElement dropdownSelectUserType;
	@FindBy(xpath="//button[@name='Create']")WebElement savebuton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertMessageofNewUserAdded;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alertMessageofUserExist;

	
	
	 public AdminUsersPage clickOnMoreInfoButton()
	{
		adminUsersmoreinfo.click();
		return this;
		
	} 
	 public AdminUsersPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public AdminUsersPage enterNewUsernameOnUsernameField(String newUsernameSendkeys)
	{
		addNewUsername.sendKeys(newUsernameSendkeys);
		return this;
	}
	public AdminUsersPage enterPasswordOnPasswordField(String newpasswordSendkeys)
	{
		addPassword.sendKeys(newpasswordSendkeys);
		return this;
	}
		
	public AdminUsersPage selectuserTypeFromDropDown(String VisibleText)
	{
		PageUtility pageutility=new PageUtility();
		pageutility.selectValueUsingSelectByVisibleText(dropdownSelectUserType,VisibleText);
		return this;
	}
	public AdminUsersPage saveButtonToAddNewUser()
	{
		savebuton.click();
		return this;
	}
	public boolean verifySaveButtonIsEnabled()
	{
		boolean saveButtonIsEnabled=savebuton.isEnabled();
		return saveButtonIsEnabled;
	}
	public boolean verifyAlertMessageIsDisplayedPostAddingNewUser()
	{
		boolean succesalertMessagepostAddingNewUser=alertMessageofNewUserAdded.isDisplayed();
		return succesalertMessagepostAddingNewUser;
	}
	public boolean verifyAlertMessageIsDisplayedIfUserAlreadyExist()
	{
		boolean dangeralertMessageUserexist=alertMessageofUserExist.isDisplayed();
		return dangeralertMessageUserexist;
	}
}
