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
import utilities.ConstantsFile;
import utilities.XlUtility;

public class SubCategoryTest extends Base {
	
	@Test(description="This is to check the file upload functionality",groups= {"Regression"},retryAnalyzer=retry.Retry.class)
	public void verifyUsernavigateToSubCategoryMoreInfoToFileUpload() throws AWTException
	{
		String expectedUsername=XlUtility.getString(1, 0, "LoginPage");
		String passwordSendkeys=XlUtility.getString(1, 1, "LoginPage");
		String filePathImage=ConstantsFile.IMAGEFILE;
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername).enterPasswordOnPasswordField(passwordSendkeys).clickOnSignButton();
		SubCategoryPage subcategorypage=new SubCategoryPage(driver);
		subcategorypage.clickOnMoreInfoButton().clickOnEditAction().fileUpload(filePathImage).clickOnUpdate().updateButtonclickableWait();
 		boolean fileIsUpLoaded=subcategorypage.verifyFileIsUploadedOrNot();
 		assertTrue(fileIsUpLoaded,"File is not uploaded");	
 		}
	@Test(description="This is for scroll subcategory page")
	public void scrollSubCategoryPage()
	{
		String expectedUsername=XlUtility.getString(1, 0, "LoginPage");
		String passwordSendkeys=XlUtility.getString(1, 1, "LoginPage");
		int pixels=250;
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername).enterPasswordOnPasswordField(passwordSendkeys).clickOnSignButton();
		SubCategoryPage subcategorypage=new SubCategoryPage(driver);
		subcategorypage.clickOnMoreInfoButton().scrollDownAdminUserSearchPage(pixels);
		
}
}
