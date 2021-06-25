package pom.classes.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileRecharge {
	@FindBy(xpath="//input [@id='mobileNumberTextInputId']")
	 private WebElement phoneno;
	
	@FindBy(xpath="//a[@id='operatorCircleLink']")
	 private WebElement edit;
	
	@FindBy(xpath="//input[@value='Jio~JIO_PRE']")
	 private WebElement JIO;
	
	@FindBy(xpath="//input[@value='Maharashtra & Goa~MAHARASHTRA_GOA']")
	 private WebElement circle;
	
	@FindBy(xpath="//a[@id='viewPlanTriggerId']")
	 private WebElement viewplan;
	
	@FindBy(xpath="//a[contains (text(),'Top Up')]")
	 private WebElement Topup;
	
	@FindBy(xpath="//input[contains(@value,'Top Up~10~')]")
	 private WebElement Topup10;
	
	@FindBy(xpath="//button[@id='buyButtonNative']")
	 private WebElement continue1;
	
	public MobileRecharge (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterphoneno()
	{
		phoneno.sendKeys("9511819807");
	}	
	
	public void clickviewplan()
	{
		viewplan.click();

	}
	
	public void clickTopup()
	{
		Topup.click();
	}
	public void clickTopup10()
	{
		Topup10.click();
	}
	
	public void clickcontinue1()
	{
		continue1.click();

	}
}
