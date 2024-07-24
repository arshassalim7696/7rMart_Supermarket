package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUtility;

public class SubCategoryPage {
public WebDriver driver ;//can acces in multiple action methods //driver is class variable 
	
	//constructor
	public SubCategoryPage(WebDriver driver)//constructor will initiate  the webdriver//driver local variable
	{
	 this.driver=driver;//name of local &class variable is same so we use this keywrd
	 PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']//child::i[@class='fas fa-arrow-circle-right']")WebElement subCategorymoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/edit?edit=406&page_ad=1']")WebElement editAction;
	@FindBy(xpath="//input[@id='main_img']")WebElement chooseFile;
	@FindBy(xpath="//button[@name='update']")WebElement update;


	public SubCategoryPage clickOnMoreInfoButton()
	{
		subCategorymoreinfo.click();
		return this;
	} 
	public SubCategoryPage clickOnEditAction()
	{
		editAction.click();
		return this;
	}
	public SubCategoryPage fileUpload(String filePathImage) throws AWTException
	{
		FileUtility fileutility=new FileUtility();
		fileutility.fileUploadUsingSendkeys(chooseFile, filePathImage);
		fileutility.fileUploadUsingRobotClass(filePathImage);
		return this;
	}
	public SubCategoryPage clickOnUpdate()
	{
		update.click();
		return this;
	} 
	public boolean verifyFileIsUploadedOrNot()
	{
		boolean fileupload=update.isDisplayed();
		return fileupload;
	}
 
}
