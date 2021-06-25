package pom.classes.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonPay {
	private WebDriver driver;
	private WebDriverWait wait; 
	
	@FindBy(xpath="//span[text()='Mobile Recharge']")
	private WebElement mobile;
	
	@FindBy(xpath="//span[text()='Electricity']")
	private WebElement electricity;
	
	@FindBy(xpath="//span[text()='DTH Recharge']")
	private WebElement dth;
	
	@FindBy(xpath="//span[text()='Mobile Postpaid']")
	private WebElement postpaid;
	
	@FindBy(xpath="//span[text()='Gas Cylinder']")
	private WebElement gasCylinder;
	
	@FindBy(xpath="//span[text()=' Insurance Premium']")
	private WebElement insurance;
	
	@FindBy (xpath="(//span[@class='nav-icon nav-arrow'])[2]")
	private WebElement dropArrow;
	
	@FindBy (xpath="//span[text()='Sign Out']")
	private WebElement signOut;
	
	
	public AmazonPay(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickMobileRecharge()
	{
		mobile.click();
	}
	
	public void clickElectricity()
	{
		electricity.click();
	}
	
	public void clickDTH()
	{
		dth.click();
	}
	
	public void clickPostpaid()
	{
		postpaid.click();
	}
	public void clickCylinder()
	{
		gasCylinder.click();
	}
	public void clickInsurance()
	{
		insurance.click();
	}
	
	
	public void clickDownArrow()
	{
		wait= new WebDriverWait(driver, 60);
		Actions mouse = new Actions(driver);
		WebElement drop = wait.until(ExpectedConditions.visibilityOf(dropArrow));
		mouse.moveToElement(drop).perform();
	}
	
	public void clickSignOut()
	{
		wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(signOut)).click();
	}
	
	
	
	
	
	
	
	
	//https://www.amazon.in/hfc/mobileRecharge?ref_=apay_deskhome_MobileRecharge
	
	//span[text()='Electricity']        https://www.amazon.in/hfc/bill/electricity?ref_=apay_deskhome_Electricity
	
	//span[text()='DTH Recharge']		https://www.amazon.in/hfc/dth?ref_=apay_deskhome_DTH
	
	//span[text()='Mobile Postpaid']		https://www.amazon.in/hfc/bill/mobile_postpaid?ref_=apay_deskhome_MobilePostpaid
	
	//span[text()='Gas Cylinder']			https://www.amazon.in/hfc/bill/lpg?ref_=apay_deskhome_LPG
		
		
		//(//span[@class="nav-icon nav-arrow"])[2]
				//span[text()='Sign Out']
}
