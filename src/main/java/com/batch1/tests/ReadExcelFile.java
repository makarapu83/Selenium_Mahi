package com.batch1.tests;

import org.openqa.selenium.By;

//import java.io.FileInputStream;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.text.SimpleDateFormat;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.batch1.pages.MTHomePage;
import com.batch1.lib.Config;

public class ReadExcelFile {
	
	public WebDriver _driver;
	
	
	
	  @Parameters("bName")
	  @BeforeTest
	  public void Test(String browser) {
		  
		  
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
		  
	  }	
	  
	  //Moving dataprovider to anothe class Config(com.batch1.lib)
	  //add dataProviderClass = Config.class next too dp in the @Test method)
	  // create a package testdata
	
	@Test(dataProvider="dp",dataProviderClass = Config.class)
	public void readDP(String u, String p){	
		System.out.println("In readDP test");
		MTHomePage mTH = PageFactory.initElements(_driver, MTHomePage.class);
		
		mTH.loginToMercuryTours(u,p);
		//_driver.get("http://newtours.demoaut.com/");
		//_driver.findElement(By.name("userName")).sendKeys(u);
		//_driver.findElement(By.name("password")).sendKeys(p);
		
	}
	
	
		
   
  
}


