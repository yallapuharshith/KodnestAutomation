package KodnestAutomation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Kodnest.page.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Test(groups= {"regression","smoke"})
public class KodLoginTest3 extends BaseTest{
	//WebDriver driver;
	String BaseUrl = "https://app.kodnest.com/login";
	LoginPage loginpage;
	String InvalidEmail;
	String UnRegistered;
	String IncorrectPassword;
	String Email ;
	String  Password;
	
	@Parameters({"InvalidEmail","UnRegistered","IncorrectPassword","Email","Password"})
	@BeforeMethod(alwaysRun = true)  // Changed from @BeforeClass
	public void setUp(String InvalidEmail, String UnRegistered, String IncorrectPassword, String Email , String  Password) {
		//driver = new ChromeDriver();
		driver.get(BaseUrl);
		//driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		this.InvalidEmail = InvalidEmail;
		this.UnRegistered = UnRegistered;
		this.IncorrectPassword = IncorrectPassword;
		this.Email = Email;
		this.Password = Password;
	}
	
	@Test(priority = 1)
	@Description("Verify login fails with blank email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login with Blank Email and Password")
	public void testBlankEmailAndPassword() {
		loginpage.clickLoginButton();
		Assert.assertEquals(loginpage.emailError(),"Email is required" );
		Assert.assertEquals(loginpage.getpasswordError(),"Please enter your password");
		
		
	}
	
	@Test(priority = 2)
	@Description("Verify login fails with invalid email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login with Invalid Credentials")
	public void testInvalidEmailFormat() {
		loginpage.enterEmail(InvalidEmail);
		loginpage.clickLoginButton();
		Assert.assertEquals(loginpage.getInvalidEmailerror(), "Invalid email format");
	}
	
	@Test(priority=3)
	@Description("Verify login fails with unregistered email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login with unregistered email")
	public void testUnregisteredEmail() {;
		loginpage.enterEmail(UnRegistered);
		loginpage.enterPassword(IncorrectPassword);
		loginpage.clickLoginButton();
		Assert.assertEquals(loginpage.getUserNotFoundError(), "User not found with this email address");
	}
	
	@Test(priority = 4)
	@Description("Verify login fails with incorrect email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Validation with incorrect credentials")
	public void testIncorrectCredentials() {
		loginpage.enterEmail(Email);
		loginpage.enterPassword(IncorrectPassword);
		loginpage.clickLoginButton();
		Assert.assertEquals(loginpage.geterrorInvalidCred(), "Incorrect Credentials");
	}
	
	@Test(priority = 5)
	@Description("Verify login passes with correct email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Validation")
	public void testValidLogin() {
		loginpage.enterEmail(Email);
		loginpage.enterPassword(Password);
		loginpage.clickLoginButton();
		Assert.assertTrue(loginpage.isExploreNowVisible());
	}
	
}