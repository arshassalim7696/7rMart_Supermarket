package testscripts;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends Base{

	@Test
	public void verifyUserLoginWithValidUsernameAndPassword()
	{
		String expectedUsername="admin";
		String passwordSendkeys="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername).enterPasswordOnPasswordField(passwordSendkeys).clickOnSignButton();
		boolean homepagenavigated=loginpage.verifyHomePageNavigated();
        assertTrue(homepagenavigated ,"Home page is not navigated even if user enters correct username and password");
   }
	@Test
	public void verifyUserisUnableToLoginWithInValidUserNameAndValidpassword()
	{
		String expectedUsername="adminadmin";
		String passwordSendkeys="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername).enterPasswordOnPasswordField(passwordSendkeys).clickOnSignButton();
		boolean isHomepagedisplayed=loginpage.verifyHomePageNotNavigated();
        assertTrue(isHomepagedisplayed,"User is able to login even if we are giving wrong Username");
	}
	@Test
	public void verifyUserisUnableToLoginWithValidUserNameAndInvalidpassword()
	{
		String expectedUsername="admin";
		String passwordSendkeys="adminadmin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername).enterPasswordOnPasswordField(passwordSendkeys).clickOnSignButton();
		boolean isHomepagedisplayed=loginpage.verifyHomePageNotNavigated();
        assertTrue(isHomepagedisplayed,"User is able to login even if we are giving wrong password");
	}
	@Test
	public void verifyUserisUnableToLoginWithInValidUserNameAndInvalidpassword()
	{
		String expectedUsername="adminadmin";
		String passwordSendkeys="adminadmin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername);
		loginpage.enterPasswordOnPasswordField(passwordSendkeys);
		loginpage.clickOnSignButton();
		boolean isHomepagedisplayed=loginpage.verifyHomePageNotNavigated();
        assertTrue(isHomepagedisplayed,"User is able to login even if we are giving wrong username and password");
	}
	

	
	
}
