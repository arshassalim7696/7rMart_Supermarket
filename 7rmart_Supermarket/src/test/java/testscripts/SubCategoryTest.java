package testscripts;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubCategoryPage;

public class SubCategoryTest extends Base {
	
	@Test
	public void verifyUsernavigateToSubCategoryMoreInfoToFileUpload() throws AWTException
	{
		String expectedUsername="admin";
		String passwordSendkeys="admin";
		String filePathImage="C:\\Users\\arsha\\OneDrive\\Pictures\\vegetables.png";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername).enterPasswordOnPasswordField(passwordSendkeys).clickOnSignButton();
		SubCategoryPage subcategorypage=new SubCategoryPage(driver);
		subcategorypage.clickOnMoreInfoButton().clickOnEditAction().fileUpload(filePathImage).clickOnUpdate();
 		 boolean fileIsUpLoaded=subcategorypage.verifyFileIsUploadedOrNot();
 		 assertTrue(fileIsUpLoaded,"File is not uploaded");	
 		}
	@Test
	public void scrollSubCategoryPage()
	{
		String expectedUsername="admin";
		String passwordSendkeys="admin";
		int pixels=250;
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername).enterPasswordOnPasswordField(passwordSendkeys).clickOnSignButton();

		SubCategoryPage subcategorypage=new SubCategoryPage(driver);
		subcategorypage.clickOnMoreInfoButton().scrollDownAdminUserSearchPage(pixels);
		
}
}
