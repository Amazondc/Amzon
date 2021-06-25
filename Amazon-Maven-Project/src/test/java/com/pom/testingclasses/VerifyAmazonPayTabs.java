package com.pom.testingclasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pom.classes.amazon.AmazonPay;
import pom.classes.amazon.HomePage;
import pom.classes.amazon.LoginPage;
import pom.classes.amazon.MobileRechargePage;
import pom.classes.amazon.Utilities1;

public class VerifyAmazonPayTabs {
	
	private WebDriver driver;
	private AmazonPay aPay;
	private HomePage home;
	private SoftAssert soft;
	private Utilities1 utility;
	static ExtentHtmlReporter reporter;
	static ExtentTest test;
	@BeforeTest
	@Parameters("browser")
	public void openBrowser(String browser)
	{
		
		reporter = new ExtentHtmlReporter("test-output//ExtendReport//Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver=Pojo.openChromeBrowser();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=Pojo.openFirefoxDriver();
		}
//		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Welcome To amazon");
		home = new HomePage(driver);
		home.clickSignIn();
		 soft = new SoftAssert();
		 utility= new Utilities1();
		 
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
	public void verifyMobileRecharge() throws EncryptedDocumentException, IOException
	{
		aPay.clickMobileRecharge();
		String url = driver.getCurrentUrl();
		
		MobileRechargePage mPay = new  MobileRechargePage(driver);
		Assert.assertEquals(url, "https://www.amazon.in/hfc/mobileRecharge?ref_=apay_deskhome_MobileRecharge");
		
		soft.assertTrue(mPay.enterMobileNo(), "The Mobile enter field is Displayed");
//		soft.assertTrue(mPay.selectCircle(), "The select Mobile circle field is Displayed");
//		soft.fail();
		soft.assertAll();
	}
	@Test //(enabled =false)
	public void verifyDTH() 
	{
		aPay.clickDTH();
		
		String url = driver.getCurrentUrl();
		
		soft.assertEquals(url, "https://www.amazon.in/hfc/dth?ref_=apay_deskhome_DTH" ); 
		
		soft.assertAll();	
	}
	
	
	@Test (enabled =false)
	public void verifyPostpaid()
	{
		aPay.clickPostpaid();
		
		String url = driver.getCurrentUrl();
		soft.assertEquals(url, "https://www.amazon.in/hfc/bill/mobile_postpaid?ref_" );
		soft.fail();
	}
	
	@Test//(enabled =false)
	public void verifyElectricity()
	{
		aPay.clickElectricity();
		
		String url = driver.getCurrentUrl();
		soft.assertEquals(url, "https://www.amazon.in/hfc/bill/electrice_Electricity" );
	}
	
	@Test  (enabled =false)
	public void verifyInsurance()
	{
		aPay.clickInsurance();
		
		String url = driver.getCurrentUrl();
		soft.assertEquals(url, "https://www.amazon.in/hfc/bill/insome_Insurance");
	}
	
	@Test  (enabled =false)
	public void verifyGasCylinder()
	{
		aPay.clickCylinder();
		
		String url = driver.getCurrentUrl();
		soft.assertEquals(url, "https://www.amazon.in/hfc/bill/lpg?re");
		
	}
	
	
	@AfterMethod
	public void signOut(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
		utility.takeScreenshot(driver);
		}
		aPay.clickDownArrow();
		aPay.clickSignOut();
		System.out.println("Thank you");
	}
	
//	@AfterClass
//	public void afterClass()
//	{
//	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();	
	}
	
//	@AfterSuite
//	public void afterSuite()
//	{
//		
//	}
	
	
	

}
