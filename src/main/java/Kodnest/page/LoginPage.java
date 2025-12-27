package Kodnest.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	private WebDriver driver;
	
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By EmailInput = By.id("email-input");
	By PasswordInput = By.id("password-input");
	By LoginButton = By.id("login-submit-button");
	By EmailError = By.id("email-error");
	By PasswordError = By.id("password-error");
	By InvalidEmailError = By.xpath("//p[@id='email-error' and text() = 'Invalid email format']");
	By UsernotfoundError = By.xpath("//div[@data-title = '' and text() = 'User not found with this email address']");
	By IncorrectCredError = By.xpath("//div[@data-title = '' and text() = 'Incorrect Credentials']");
	By ChatwithBroKodButton = By.className("ExploreNow");
	
	public void enterEmail(String email) {
		WebElement emailField = driver.findElement(EmailInput);
		emailField.clear();
		emailField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		WebElement passwordField = driver.findElement(PasswordInput);
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(LoginButton).click();
	}
	
	public String emailError() {
		return driver.findElement(EmailError).getText();
	}
	
	public String getpasswordError() {
		return driver.findElement(PasswordError).getText();
	}
	
	public String getInvalidEmailerror() {
		return driver.findElement(InvalidEmailError).getText();
	}
	
	public String geterrorInvalidCred() {
		 return new WebDriverWait(driver, Duration.ofSeconds(5))
			        .until(ExpectedConditions.visibilityOfElementLocated(IncorrectCredError))
			        .getText();

		
	}
	public String getUserNotFoundError() {
		 return new WebDriverWait(driver, Duration.ofSeconds(5))
			        .until(ExpectedConditions.visibilityOfElementLocated(UsernotfoundError))
			        .getText();

	}
	public boolean isExploreNowVisible() {
	    return new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(ExpectedConditions.visibilityOfElementLocated(ChatwithBroKodButton))
	        .isDisplayed();
	}

	
	
	
}