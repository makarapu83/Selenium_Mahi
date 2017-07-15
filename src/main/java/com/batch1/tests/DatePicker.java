package com.batch1.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.batch1.lib.Config;

public class DatePicker extends Config{
	WebDriver _driver;
	
	@Parameters("bName")
	  @BeforeTest
	public void setup(String browser){
		
		_driver = Config.initializeDriver(browser);
		
	}
	
	@Test
  public void datepickr() {
	  
	  
  _driver.get("https://jqueryui.com/datepicker/");
	  
	  
	  //_driver.findElement(By.tagName("//iframe"));
	  
	  
	  
	  Actions act = new Actions(_driver);
	  
	  //Thread.sleep(20000);
	  WebElement frm = _driver.findElement(By.xpath("//iframe"));
	  waitSwitchToFrame(_driver,50,frm);
	  // _driver.switchTo().frame(frm);
	  
	  
	  _driver.findElement(By.className("hasDatepicker")).click();
	  
	  WebElement dateSelect = _driver.findElement(By.xpath("//tbody/descendant::a[text()=3]"));
	  waitDriverElementToClickable(_driver,30,dateSelect);
	  dateSelect.click();
  }
}
