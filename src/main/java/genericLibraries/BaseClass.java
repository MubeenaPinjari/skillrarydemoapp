package genericLibraries;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.AddNewCategoryPage;
import pomPages.AddNewCoursePage;
import pomPages.AddNewuserPage;
import pomPages.AdminHomepage;
import pomPages.CategoryPage;
import pomPages.CourseListpage;
import pomPages.Loginpage;
import pomPages.Userspage;
import pomPages.WelcomePage;

public class BaseClass {

	//@BeforeSuite
	//@BeforeTest
	
	protected PropertiesUtility property;
	protected Excelutility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility webUtil;
	protected WebDriver driver;
	
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	
	protected WelcomePage welcome;
	protected Loginpage login;
	protected AdminHomepage home;
	protected Userspage users;
	protected Courselistpage course;
	protected CategoryPage category;
	protected AddNewuserPage addUser;
	protected AddNewCoursePage addCourse;
	protected AddNewCategoryPage addCategory;
	
	@BeforeClass
	public void classConfig() {
		property = new PropertiesUtility();
		excel = new Excelutility();
		jutil = new JavaUtility();
		webUtil = new WebDriverUtility();
		
		property.propertiesInitialization(IConstantPath.PROPERTIES_PATH);
		driver = webUtil.launchBrowser(property.readFromProperties("browser"));
		
		sdriver = driver;
		sjutil = jutil;
	}
	
	@BeforeMethod
	public void methodConfig() throws InterruptedException {
		excel.excelInitialization(IConstantPath.EXCEL_PATH);
		
		welcome = new WelcomePage(driver);
		login = new Loginpage(driver);
		home = new AdminHomepage(driver);
		users = new Userspage(driver);
		course = new Courselistpage(driver);
		category = new Categorypage(driver);
		addUser = new AddNewuserPage(driver);
		addCourse = new AddNewCoursePage(driver);
		addCategory = new AddNewCategoryPage(driver);
		
		webUtil.navigateToApp(property.readFromProperties("url"));
		Assert.assertEquals(welcome.getLogo(), "SkillRary-ECommerce");
		
		long time = Long.parseLong(property.readFromProperties("timeouts"));
		webUtil.waitTillElementFound(time);
		
		welcome.clickLoginButton();
		Assert.assertEquals(login.getPageHeader(), "Login");
		
		login.setEmail(property.readFromProperties("username"));
		login.setPassword(property.readFromProperties("password"));
		login.clickLogin();
		
		Assert.assertEquals(home.getAdminIcon(), "SkillRary Admin");
	}
	
	@AfterMethod
	public void methodTeardown() {
		excel.closeExcel();
		home.signOutofApp();
	}
	
	@AfterClass
	public void classTeardown() {
		webUtil.closeAllWindows();
	}
	
	//@AfterTest
	//@AfterSuite
}