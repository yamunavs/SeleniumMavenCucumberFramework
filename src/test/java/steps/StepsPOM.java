package steps;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utilityclasses.ExtentReportsUtility;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.home.HomePage;
import pages.login.ForgetPasswordPage;
import pages.login.LoginPage;

public class StepsPOM  {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	ForgetPasswordPage forgetPasswordPage;
	protected static ExtentReportsUtility ExtentReport=ExtentReportsUtility.getInstance();
	protected static Logger logger=LogManager.getLogger(BaseTest.class.getName());
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Given("user open salesforce application")
	public void user_open_salesforce_application() {
	   driver.get("https://login.salesforce.com/");
	}

	@When("user on {string}")
	public void user_on(String page) {
		switch (page) {
		case "LoginPage":
			 loginPage = new LoginPage(driver);
			break;
		case "HomePage":
			 homePage = new HomePage(driver);
			 break;
		case "ForgetPasswordPage":
		     forgetPasswordPage = new ForgetPasswordPage(driver);
		     break;
		default:
			break;
		}
	}

	@When("user enter value into text box username as {string}")
	public void user_enter_value_into_text_box_username_as(String data) {
		
		loginPage.enterUserName(data);
		logger.info("valid username is entered");
		ExtentReport.logTestInfo("valid username is entered");
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		loginPage.clickLogin();
	}

	@Then("verify error message as {string}")
	public void verify_error_message_as(String expected) {
       String actual=loginPage.getErrorMessage();
		
		assertEquals(actual, expected);
	}

	@When("user enter value into text box password as {string}")
	public void user_enter_value_into_text_box_password_as(String password) {
		loginPage.enterPassword(password);
	}
    
	

	@Then("verify pagetitle as {string}")
	public void verify_pagetitle_as(String expectedPageTitle) {
		//homePage.waitUntilLoggedInUserAppear();
	    String actual =homePage.getTitleOfPage();
		assertEquals(actual, expectedPageTitle);
	}

	@When("user click on remember me button")
	public void user_click_on_remember_me_button() {
		loginPage.clickRembemberMe();
	}
 
		@When("user click on LoggedinUser dropdown")
		public void user_click_on_loggedin_user_dropdown() {
			homePage.clickLoggedInUser();
		}

	@When("user click on logout button")
	public void user_click_on_logout_button() {
		homePage.clickLogout();
	}

	@Then("verify username in username field is {string}")
	public void verify_username_in_username_field_is(String expected) {
		String actual = loginPage.getUserName();
		assertEquals(actual, expected);
	}

	@When("user click on ForgetPassword link")
	public void user_click_on_forget_password_link() {
		loginPage.clickForgetPassword();
	}

	@When("user click on continue button")
	public void user_click_on_continue_button() {
		forgetPasswordPage.clickContinueButton();

	}

	@When("user enter value into text box username in forget password page as {string}")
	public void user_enter_value_into_text_box_username_in_forget_password_page_as(String username) {
		forgetPasswordPage.enterUserName(username);
	   
	}
	@After
public void tearDown() {
	driver.close();
}
	
}
