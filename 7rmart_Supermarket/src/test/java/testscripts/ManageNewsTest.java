package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.XlUtility;

public class ManageNewsTest extends Base {
	@Test(description="This is to verify user is able to add news in the news field",groups= {"Regression"},retryAnalyzer=retry.Retry.class)
	public void verifyUserIsAbleToAddNewsOnNewsField() 
	{
		String expectedUsername=XlUtility.getString(1, 0, "LoginPage");
		String passwordSendkeys=XlUtility.getString(1, 1, "LoginPage");
        String newsText = "Sample news";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername).enterPasswordOnPasswordField(passwordSendkeys).clickOnSignButton();
        ManageNewsPage managanewspage=new ManageNewsPage(driver);
        managanewspage.clickOnmanageNewsInfo().clickOnNewButton().enteringNewsOnTextField(newsText).clickOnSaveButton();
        managanewspage.verifyManageNewsPageNavigated();
        boolean isNewsAdded = managanewspage.verifyAddedNews();
        assertTrue(isNewsAdded, "News entered was not added succesfully");
    }
    
      
	@Test(description="This is to verify the user is able to edit the news field",groups= {"Regression"},retryAnalyzer=retry.Retry.class)
	public void verifyUserIsAbleToEditTheNewsTextField()
      {
		String expectedUsername=XlUtility.getString(1, 0, "LoginPage");
		String passwordSendkeys=XlUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(expectedUsername).enterPasswordOnPasswordField(passwordSendkeys).clickOnSignButton();
        String newsText = "test news updated under manage news";
        ManageNewsPage managanewspage=new ManageNewsPage(driver);
        managanewspage.clickOnmanageNewsInfo().clickOnEditButton().enteringNewsOnTextField(newsText).clickOnUpdateButton().updateButtonclickableWait();
        managanewspage.verifyManageNewsPageNavigated();
        boolean isNewsUpdated=managanewspage.verifyUpdatedNews();
        assertTrue(isNewsUpdated, "News was not updated succesfully ");
        
       }
        
    }