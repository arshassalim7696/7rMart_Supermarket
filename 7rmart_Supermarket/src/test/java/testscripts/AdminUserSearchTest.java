package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.AdminUserSearchPage;

public class AdminUserSearchTest extends Base {
	
	@Test
	public void verifyUsernavigateToAdminUsersMoreInfoToAddNewUsers()
	{
		String expectedUsername="admin";
		String passwordSendkeys="admin";
		String ExistingUsernameSendkeys="Ramuram";
		String dropDownSelectValue="Admin";
		int pixels=350;
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername).enterPasswordOnPasswordField(passwordSendkeys).clickOnSignButton();
		AdminUserSearchPage adminusersearch=new AdminUserSearchPage(driver);
		adminusersearch.clickOnMoreInfoButton().clickOnSearchButton().enterAdminUsernameOnUsernameField(ExistingUsernameSendkeys).selectuserTypeFromDropDown(dropDownSelectValue).clickOnSubmitSearchButton().scrollDownAdminUserSearchPage(pixels).scrollUpAdminUserSearchPage(pixels);
   		boolean searchedUserStatus=adminusersearch.verifySearchedUserIsAvailableOrNotInTableList();
        assertTrue(searchedUserStatus,"User is not available in the list");
       
	}
	@Test
	public void verifyUserisAbleToResetTheSearchedItem()
	{
		String expectedUsername="admin";
		String passwordSendkeys="admin";
		String ExistingUsernameSendkeys="Ramuram";
		String dropDownSelectValue="Admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername).enterPasswordOnPasswordField(passwordSendkeys).clickOnSignButton();
		AdminUserSearchPage adminusersearch=new AdminUserSearchPage(driver);
		adminusersearch.clickOnMoreInfoButton().clickOnSearchButton().enterAdminUsernameOnUsernameField(ExistingUsernameSendkeys).selectuserTypeFromDropDown(dropDownSelectValue).clickOnSubmitSearchButton().clickOnResetButton();
 		boolean resetIsDone=adminusersearch.verifyResetIsSuccesOrNot();
 		assertTrue(resetIsDone,"User is not able to reset");
	}
}
