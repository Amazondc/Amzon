package com.pom.testclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import pom.classes.amazon.HomePage;
import pom.classes.amazon.LoginPage;

public class AmazonSignIn {
  @BeforeClass
  public void demo()
  {
	  
  }
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver","D:\\Velocity\\Selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		HomePage login1 = new HomePage(driver); 
		
		login1.clickSignIn();
		
		Thread.sleep(10000);
		
		LoginPage login2 = new LoginPage(driver);
		
		login2.enterEmail();
		login2.clickContinue();
		login2.enterPassword();
		login2.clickSignIn();
		
		
		
		
		
	}

}
