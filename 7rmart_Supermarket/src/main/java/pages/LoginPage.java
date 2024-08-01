package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver ;//can acces in multiple action methods //driver is class variable 
	
	//constructor
	public LoginPage(WebDriver driver)//constructor will initiate  the webdriver//driver local variable
	{
	 this.driver=driver;//name of local &class variable is same so we use this keywrd
	 PageFactory.initElements(driver,this);
	}
	
	//Locators
	@FindBy(xpath="//input[@placeholder='Username']")private WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")private WebElement password;
 	@FindBy(xpath="//button[@class='btn btn-dark btn-block']")private WebElement sigIn;
	@FindBy(xpath="//a[text()='Home']")private WebElement home;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement invalidCredentialAlert;


	//Action methods
	public LoginPage enterUsernameOnUsernameField(String expectedUsername)
	{
		username.sendKeys(expectedUsername);
		return this;
	}
	public LoginPage enterPasswordOnPasswordField(String passwordSendkeys)
	{
		password.sendKeys(passwordSendkeys);
		return this;
	}
	public LoginPage clickOnSignButton()
	{
		sigIn.click();
		return this;
	}
	public boolean verifyHomePageNavigated()
	{
		boolean isHomepageNavigated =home.isDisplayed();
		return isHomepageNavigated;
	}
	public boolean verifyHomePageNotNavigated()
	{
		boolean alertMessageavailable=invalidCredentialAlert.isDisplayed();
		return alertMessageavailable;
	}
	
}
