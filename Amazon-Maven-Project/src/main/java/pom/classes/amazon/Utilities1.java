package pom.classes.amazon;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities1{
	
	static  int rvalue, cvalue;
	static private String path;
	private Sheet Sheet;
	private Row row;
	private String data;
	
	public void sendExcelPath(String P)
	{
		path=P;
		
	}
	public String excelData(int s, int r, int c) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(path);
		Workbook w =WorkbookFactory.create(file);
		Sheet =w.getSheetAt(s);
		row = Sheet.getRow(r);
		Cell cell = row.getCell(c);
		try {
		data = cell.getStringCellValue();
		}
		catch(IllegalStateException e)
		{
		long numericVal = (long) cell.getNumericCellValue();
		System.out.println(numericVal);
		data=String.valueOf(numericVal); 
		}
		return data;
//		rvalue= Sheet.getLastRowNum();
//		cvalue= row.getLastCellNum();
		
	}
	
	
	public void takeScreenshot(WebDriver driver ) throws IOException
	{
		 SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");  
		  Date date = new Date();
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\Velocity\\AutomatedSS\\AutoScreenShot "+dtf.format(date)+".jpeg");
		FileHandler.copy(source, dest);
	}
	
	public String multipleExcelData(int s) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(path);
		Workbook w =WorkbookFactory.create(file);
		Sheet =w.getSheetAt(s);
		for (int i =0; i<=Sheet.getLastRowNum(); i++)
		{
			row = Sheet.getRow(i);
			for(int j=0; j<row.getLastCellNum(); j++)
			{
				Cell cell = row.getCell(j);
				try
				{
				data = cell.getStringCellValue();
				}
				catch(IllegalStateException e)
				{
				long	d = (long)cell.getNumericCellValue();
				data=String.valueOf(d); 
				}
				System.out.print(data+" | ");
			}
			System.out.println();
		}
		
		 return null;
	}
	
	public String LimitedExcelData(int s, int r, int c) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(path);
		Workbook w =WorkbookFactory.create(file);
		Sheet =w.getSheetAt(s);
		for (int i =0; i<=r; i++)
		{
			for(int j=0; j<c; j++)
			{
				row = Sheet.getRow(i);
				Cell cell = row.getCell(j);
				data = cell.getStringCellValue();
				 System.out.print(data+" | ");
			}
			System.out.println();
		}
		
		 return null;
	}
	
	

}
