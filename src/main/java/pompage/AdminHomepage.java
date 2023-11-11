package pompage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomepage {
//declaration
	@FindBy(xpath="//span[text()='SkillRary Admin']")
	   private WebElement adminicon;
	
	@FindBy(xpath = "//span[text()='Users']")
	private WebElement usertab;
	
	@FindBy(xpath = "//span[text()='Courses']")
	private WebElement coursetab;
	
	@FindBy(xpath = "//a[text()=' Course List']")
	private WebElement courselistlink;
	
	@FindBy(xpath = "//a[text()=' Category']")
	private WebElement categorylink;
	
	@FindBy(xpath = "//a[text()='Sign out']")
	private WebElement signoutlink;
	
	
	//Initialization
	
	public 	AdminHomepage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization
	public String getadminicon()
	{
		return adminicon.getText();
	}
	public void clickusertab()
	{
		usertab.click();
	}
	public void clickcousestab()
	{
		coursetab.click();
	}
    public void clickcourselistlink()
    {
    	courselistlink.click();
    }
	public void Clickcategorylink()
	{
		categorylink.click();
	}
	public void signoutoffapp()
	{
		adminicon.click();
		signoutlink.click();
	}
	
}