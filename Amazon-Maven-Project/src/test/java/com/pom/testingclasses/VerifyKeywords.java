package com.pom.testingclasses;

import java.io.IOException;
import java.math.BigInteger;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.classes.amazon.Utilities1;

public class VerifyKeywords  {
			
//		private static final String firstTimeOnly = null;
	private Utilities1 utility;
	private WebDriver driver;
		@BeforeClass
		public void beforeClass()
		{
			
		System.out.println("Before Class");	
		utility = new Utilities1();
		}
		
		@BeforeMethod(firstTimeOnly=true )
		public void beforeMethod()
		{
			System.out.println("Before Method");
			BigInteger b = new BigInteger("8087795997");
			
			System.out.println(b);
		}
	
		
		@Test (priority=1)
		public void test1() throws EncryptedDocumentException, IOException
		{
			utility.sendExcelPath("D:\\Velocity\\Selenuim.xlsx");
			
			String store = utility.excelData(0, 2,2 );
			
			System.out.println("*"+store+"*");
			System.out.println("Test1");
		}
		
		@Test(priority=2)
		public void test2() throws EncryptedDocumentException, IOException
		{
			utility.sendExcelPath("D:\\Velocity\\Selenuim.xlsx");
			utility.multipleExcelData(0);
			System.out.println("Test2");
			
			
		}
		@Test(priority=3, enabled =false)
		public void test3() throws EncryptedDocumentException, IOException
		{
			utility.sendExcelPath("D:\\Velocity\\Selenuim.xlsx");
			utility.LimitedExcelData(0, 6, 2);
			System.out.println("Test3");
			
			
		}
		@Test(priority=4, enabled =false)
		public void test4()
		{
			System.out.println("Test4");
		}
		@Test(priority=5)
		public void test5() throws IOException
		{
			System.out.println("Test5");
		}
		
		@AfterMethod    
		public void afterMethod()
		{
			System.out.println("After Method");
		}
		
		@AfterClass
			public void afterClass()
			{
				System.out.println("After Class");
				
			}
		
		
		
	
}
