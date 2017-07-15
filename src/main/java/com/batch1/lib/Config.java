package com.batch1.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Config {
	
	public static WebDriver _driver;
	
	
	  public static WebDriver initializeDriver(String browser) {
		  
		  
		  if(browser.equalsIgnoreCase("firefox")){
			  
			 _driver = new FirefoxDriver();
			  System.out.println("The value of the browser is : " + browser);			  
			  
		  }else if(browser.equalsIgnoreCase("ie")){
			  
			  
			  System.out.println("The value of the browser is : " + browser);  
			  System.setProperty("webdriver.ie.driver", "F:/softwares/IEDriverServer.exe");
			  _driver = new InternetExplorerDriver();			  
			  
			  
		  } else if(browser.equalsIgnoreCase("chrome")){
			  System.out.println("The value of the browser is : " + browser);  
			  System.setProperty("webdriver.chrome.driver", "F:/softwares/chromedriver.exe");
			  _driver = new ChromeDriver();			  
			  
		  }
		return _driver;
		  
	  }	
	
	
	public void waitDriverElementToClickable(WebDriver wd, int time,WebElement element){
		WebDriverWait wait = new WebDriverWait(wd,time);
		
		wait.until(ExpectedConditions.elementToBeClickable(element));	
		
	}
	
	public void waitSwitchToFrame(WebDriver wd, int time,WebElement locator){
		WebDriverWait wait = new WebDriverWait(wd,time);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		
		
	}
	
	@DataProvider
	  public static Object[][] dp() throws IOException{
		System.out.println("In Data Provider");
		  
		  int rowCount;
		  int colCount;
		   
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+File.separator+"/src/main/java/com/batch1/testdata/test.xlsx"); // we take the test data file
			XSSFWorkbook wb = new XSSFWorkbook(fs); // Pass the test data file to POI library -- XSSFWorkbook which reads the file
			
			XSSFSheet sheet = wb.getSheet("credentials"); // We are reading the sheet	
			 rowCount = sheet.getLastRowNum(); // getting the max row number
			 colCount = sheet.getRow(0).getLastCellNum(); //getting the column number
			 
			 //System.out.println("The row value is : " + rowCount+ " AND the last row is " + colCount);		 
			 
			 Object[][] dataobj = new Object[rowCount][colCount] ; // 
			 for (int i=1;i<= sheet.getLastRowNum(); i++){		/// rows iteration	 
			 
				XSSFRow row = sheet.getRow(i);// row to iterate // 1st row 5
				
				//System.out.println("The row value is : " + i+ " AND the last row is " + sheet.getLastRowNum());
				
				
				for(Cell cell : row){// iterate cells
					//row.getLastCellNum();
					
					//System.out.println("The cell index is : " + cell.getColumnIndex());
					switch (cell.getCellType()){	 //String			
						
					
						case XSSFCell.CELL_TYPE_NUMERIC:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							//dataobj[0][0] = UserName
							//dataobj[0][1] = Password  row 1 values assigned to the array
							
							//dataobj[1][0] = Mahendar
							//dataobj[1][1] = 12345  row 2 values assigned to the array
							
							//System.out.println((int)cell.getNumericCellValue());
							dataobj[i-1][cell.getColumnIndex()] = cell.getStringCellValue();
							//System.out.println("The Numeric is : " + dataobj[i][cell.getColumnIndex()]);
							//1,1 = 12345
							//2,1 == 45677
							break;
							
						case XSSFCell.CELL_TYPE_STRING:
							
							//System.out.println(cell.getRichStringCellValue());
							dataobj[i-1][cell.getColumnIndex()] = cell.getStringCellValue();
							//System.out.println("The String is : " + dataobj[i][cell.getColumnIndex()]);
							//  [1][0]             Mahendar
							//2,0 == Dileep
							//3,0 == Naresh
							//3,1 == asda444
							//4,0 == Suresh
							//4,1 == djfhskdfj
							break;
							
						case XSSFCell.CELL_TYPE_BLANK:
							//System.out.println(" No value in the field");
							break;						
						
					}
					
				}			
				
			}
		 
		  
		// returing the object array to the data provider test
			 return dataobj;
		
		  
	  }
	 
}
