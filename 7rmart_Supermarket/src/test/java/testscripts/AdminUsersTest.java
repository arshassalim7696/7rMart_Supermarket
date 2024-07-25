package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;

public class AdminUsersTest extends Base{ 
	
	@Test
	public void verifyUsernavigateToAdminUsersMoreInfoToAddNewUsers()
	{
		String expectedUsername="admin";
		String passwordSendkeys="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername).enterPasswordOnPasswordField(passwordSendkeys).clickOnSignButton();
		String dropDownSelectValue="Admin";

		String newUsernameSendkeys="Ramuram";
		String newpasswordSendkeys="ramuadmin";
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOnMoreInfoButton().clickOnNewButton().enterNewUsernameOnUsernameField(newUsernameSendkeys).enterPasswordOnPasswordField(newpasswordSendkeys).selectuserTypeFromDropDown(dropDownSelectValue).saveButtonToAddNewUser().performingMouseActionToContextClick();
		boolean issavebuttonisenabled=adminuserspage.verifySaveButtonIsEnabled();
        assertTrue(issavebuttonisenabled,"User is not able to clcik savebutton to add new users details");
        /*boolean alertMessageForNewUser=adminuserspage.verifyAlertMessageIsDisplayedPostAddingNewUser();
        assertTrue(alertMessageForNewUser,"NewUser is not create succesfully because user already exist");*/
        boolean alertMessageForUserExist=adminuserspage.verifyAlertMessageIsDisplayedIfUserAlreadyExist();
        assertTrue(alertMessageForUserExist,"This user is not exist danger alert is not displayed");
	}
	

}
