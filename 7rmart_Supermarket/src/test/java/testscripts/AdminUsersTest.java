package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.XlUtility;

public class AdminUsersTest extends Base{ 
	
	@Test(description="This is for verifying user is navigating to adminuser psge to add new user",groups= {"Regression"},retryAnalyzer=retry.Retry.class)
	public void verifyUsernavigateToAdminUsersMoreInfoToAddNewUsers()
	{
		String expectedUsername=XlUtility.getString(1, 0, "LoginPage");
		String passwordSendkeys=XlUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername).enterPasswordOnPasswordField(passwordSendkeys).clickOnSignButton();
		String dropDownSelectValue="Admin";

		String newUsernameSendkeys="Ramuram";
		String newpasswordSendkeys="ramuadmin";
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOnMoreInfoButton().clickOnNewButton().enterNewUsernameOnUsernameField(newUsernameSendkeys).enterPasswordOnPasswordField(newpasswordSendkeys).selectuserTypeFromDropDown(dropDownSelectValue).saveButtonToAddNewUser().performingMouseActionToContextClick();
		boolean issavebuttonisenabled=adminuserspage.verifySaveButtonIsEnabled();
        assertTrue(issavebuttonisenabled,"User is not able to clcik savebutton to add new users details");
        boolean alertMessageForUserExist=adminuserspage.verifyAlertMessageIsDisplayedIfUserAlreadyExist();
        assertTrue(alertMessageForUserExist,"This user is not exist danger alert is not displayed");
	}
	

}
