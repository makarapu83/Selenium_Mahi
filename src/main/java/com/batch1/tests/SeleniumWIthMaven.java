package com.batch1.tests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class SeleniumWIthMaven {
	
	
	public WebDriver _driver;
	
  @Test
  public void openUrl() {
	  
	  System.out.println("This is my test method");
	  _driver.get("http://google.co.in/");
	  _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
  }
  
  @Test
  public void searchString(){
	  
	  WebDriverWait wt = new WebDriverWait(_driver,30);
	  wt.until(ExpectedConditions.elementToBeClickable(By.id("lst-ib")));
	  _driver.findElement(By.id("lst-ib")).clear();
	  _driver.findElement(By.id("lst-ib")).sendKeys("selenium webdriver"); // searching for webdriver in google.com
		_driver.findElement(By.name("btnG")).click();	// click on serach icon
		
		_driver.findElement(By.partialLinkText("Downloads - Selenium")).click(); // selecting the selenium website link	
	  
  }
  
  
  
  
  
  @Parameters("bName")
  @BeforeTest
  public void beforeTest(String browser) {
	  
	  
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

}
