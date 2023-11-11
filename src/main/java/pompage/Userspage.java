package pompage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Userspage {
	
	
	//declaration
	
	@FindBy(xpath="//h1[normalize-space(text() )='Users']")
	private WebElement pageHeader;
     
	@FindBy(xpath=" //a[text()=' New']")
	private WebElement pluseNewButton;
	
	@FindBy(xpath="//ul[@class='pagination']/li[last()-1]/a")
	private WebElement userListLastpage;
	
    @FindBy(xpath="//table/tbody/tr[last()]/td[3]")
    private WebElement lastuser;
    
   // @FindBy(xpath=" //h4[text()=' Success!']")
	//private WebElement successMessage;
	
    @FindBy(xpath=" //h4[text()=' Success!']")
	private WebElement successMessage;
    
  //Initialization
  	public Userspage(WebDriver driver)
  	{
  		PageFactory.initElements(driver,this);
  	}
  	//Utilization
  	public String getPageHeader() {
  		return pageHeader.getText();
  	}
  	public void clickNewButton() {
  		pluseNewButton.click();
  	}
  	public void clickUserListLastPage() {
  		userListLastpage.click();
  	}
  	public String getLastUserName() {
  		return lastuser.getText();
  	}
     
  	public String getSuccessMessage()
	{
		return successMessage.getText();
	}
}	
  	
  