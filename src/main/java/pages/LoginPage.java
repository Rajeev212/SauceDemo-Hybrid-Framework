package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class LoginPage {
	
	WebDriver driver;
	WaitUtils wait;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		wait = new WaitUtils(driver);
	}
	
	By username = By.id("user-name");
	By password = By.id("password");
	By loginBtn = By.id("login-button");
	By errorMsg = By.xpath("//h3[@data-test='error']");
	
	public void login(String user, String pass) {

	    wait.waitForVisibility(username).sendKeys(user);
	    wait.waitForVisibility(password).sendKeys(pass);
	    wait.waitForClickable(loginBtn).click();
	}
	
	public String getErrorMessage() {
	    return wait.waitForVisibility(errorMsg).getText();
	}
	
}

