package com.pom.testingclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.classes.amazon.AmazonPay;
import pom.classes.amazon.HomePage;
import pom.classes.amazon.LoginPage;

public class VerifyUsingChrome {
	
	private WebDriver driver;
	private AmazonPay aPay;
	private HomePage home;
	
	@BeforeTest
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Velocity\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
//		driver.manage().window().maximize();
		System.out.println("Welcome To amazon");
		home = new HomePage(driver);
		home.clickSignIn();
	}
	
	
	@BeforeMethod
	public void beforeMethod()
	{
		LoginPage login = new LoginPage(driver);
		login.enterEmail();
		login.clickContinue();
		login.enterPassword();
		login.clickSignIn();
		System.out.println("Log in successfull");
		
		home.clickAmazonPay();
		aPay = new AmazonPay(driver);
	}
	
	@Test
	public void verifyMobileRecharge()
	{
		 
		aPay.clickMobileRecharge();
		String url = driver.getCurrentUrl();
		if(url.equalsIgnoreCase("https://www.amazon.in/hfc/mobileRecharge?ref_=apay_deskhome_MobileRecharge"))
		{
			System.out.println("Mobile Pass 1");
		}
		else
		{
			System.out.println("Mobile Fail");
		}		
	}
	
	@Test
	public void verifyDTH()
	{
		aPay.clickDTH();
		
		String url = driver.getCurrentUrl();
		if(url.equalsIgnoreCase("https://www.amazon.in/hfc/dth?ref_=apay_deskhome_DTH"))
		{
			System.out.println("DTH Pass 4");
		}
		else
		{
			System.out.println("DTH Fail");
		}		
	}
	
	@Test
	public void verifyPostpaid()
	{
		aPay.clickPostpaid();
		
		String url = driver.getCurrentUrl();
		if(url.equalsIgnoreCase("https://www.amazon.in/hfc/bill/mobile_postpaid?ref_=apay_deskhome_MobilePostpaid"))
		{
			System.out.println("Postpaid Pass 5");
		}
		else
		{
			System.out.println("Postpaid Fail");
		}		
	}
	
	@Test
	public void verifyElectricity()
	{
		aPay.clickElectricity();
		
		String url = driver.getCurrentUrl();
		if(url.equalsIgnoreCase("https://www.amazon.in/hfc/bill/electricity?ref_=apay_deskhome_Electricity"))
		{
			System.out.println("Electrcity Pass 2");
		}
		else
		{
			System.out.println("Electricity Fail");
		}		
	}
	
	@Test
	public void verifyInsurance()
	{
		aPay.clickInsurance();
		
		String url = driver.getCurrentUrl();
		if(url.equalsIgnoreCase("https://www.amazon.in/hfc/bill/insurance?ref_=apay_deskhome_Insurance"))
		{
			System.out.println("Insurance Pass 6");
		}
		else
		{
			System.out.println("Insurance Fail");
		}		
	}
	
	@Test
	public void verifyGasCylinder()
	{
		aPay.clickCylinder();
		
		String url = driver.getCurrentUrl();
		if(url.equalsIgnoreCase("https://www.amazon.in/hfc/bill/lpg?ref_=apay_deskhome_LPG"))
		{
			System.out.println("Cylinder Pass 3");
		}
		else
		{
			System.out.println("Cylinder Fail");
		}		
	}
	@AfterMethod
	public void signOut()
	{
		aPay.clickDownArrow();
		aPay.clickSignOut();
		System.out.println("Thank you");
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

	
	
	

}
