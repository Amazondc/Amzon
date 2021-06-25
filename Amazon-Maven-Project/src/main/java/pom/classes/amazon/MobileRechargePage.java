package pom.classes.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileRechargePage {
	
	@FindBy (xpath = "(//input[@type='tel'])[1]")
	private WebElement mobileNo;
	
	@FindBy (xpath ="//a[@id='operatorCircleLink']")
	private WebElement circle;
	
	@FindBy (xpath ="//a[@id='viewPlanTriggerId']")
	private WebElement viewPlan;
	
	@FindBy (xpath ="//span[@id='payButtonText']")
	private WebElement payNow;
	
	public MobileRechargePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean enterMobileNo() {
		
	boolean mobile= mobileNo.isDisplayed();
	return mobile;
	
	}
	
	public boolean selectCircle() {
		
		boolean cir= circle.isDisplayed();
		return cir;
		
	}
	
}
