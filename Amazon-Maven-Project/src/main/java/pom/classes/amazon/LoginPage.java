package pom.classes.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath = "//input[@id='ap_email']")
	private WebElement emailId;

	@FindBy(xpath = "//input[@id='continue']")
	private WebElement next;

	@FindBy(xpath = "//input[@id='ap_password']")
	private WebElement password;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	private WebElement signInButton;

	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail()
	{
		emailId.sendKeys("dhirajashtankar@gmail.com");
	}
	
	public void clickContinue()
	{
		next.click();
	}
	
	public void enterPassword()
	{
		password.sendKeys("Amazon@0210");
	}
	
	public void clickSignIn()
	{
		signInButton.click();
	}

}
