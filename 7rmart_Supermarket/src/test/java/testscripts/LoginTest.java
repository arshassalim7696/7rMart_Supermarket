package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.XlUtility;

public class LoginTest extends Base{

	@Test(description="This is for verifying loginpage with valid credentials ",groups= {"Smoke"},retryAnalyzer=retry.Retry.class)
	public void verifyUserLoginWithValidUsernameAndPassword()
	{
		String expectedUsername=XlUtility.getString(1, 0, "LoginPage");
		String passwordSendkeys=XlUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername).enterPasswordOnPasswordField(passwordSendkeys).clickOnSignButton();
		boolean homepagenavigated=loginpage.verifyHomePageNavigated();
        assertTrue(homepagenavigated ,"Home page is not navigated even if user enters correct username and password");
   }
	@Test
	public void verifyUserisUnableToLoginWithInValidUserNameAndValidpassword()
	{
		String expectedUsername=XlUtility.getString(1, 2, "LoginPage");
		String passwordSendkeys=XlUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername).enterPasswordOnPasswordField(passwordSendkeys).clickOnSignButton();
		boolean isHomepagedisplayed=loginpage.verifyHomePageNotNavigated();
        assertTrue(isHomepagedisplayed,"User is able to login even if we are giving wrong Username");
	}
	@Test
	public void verifyUserisUnableToLoginWithValidUserNameAndInvalidpassword()
	{
		String expectedUsername=XlUtility.getString(1, 0, "LoginPage");
		String passwordSendkeys=XlUtility.getString(1, 3, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername).enterPasswordOnPasswordField(passwordSendkeys).clickOnSignButton();
		boolean isHomepagedisplayed=loginpage.verifyHomePageNotNavigated();
        assertTrue(isHomepagedisplayed,"User is able to login even if we are giving wrong password");
	}
	@Test(dataProvider="LoginProvider" )
	public void verifyUserisUnableToLoginWithInValidUserNameAndInvalidpassword(String expectedUsername,String passwordSendkeys)
	{
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername).enterPasswordOnPasswordField(passwordSendkeys).clickOnSignButton();
		boolean isHomepagedisplayed=loginpage.verifyHomePageNotNavigated();
        assertTrue(isHomepagedisplayed,"User is able to login even if we are giving wrong username and password");
	}
	
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { {XlUtility.getString(1, 2, "LoginPage"), XlUtility.getString(1, 3, "LoginPage") },

		};
	
	
}}
