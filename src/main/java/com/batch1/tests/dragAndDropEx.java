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
import com.batch1.lib.*;

public class dragAndDropEx extends Config{
  
	WebDriver _driver;

	@Parameters("bName")
	@BeforeTest
	public void setup(String browser){
		_driver = Config.initializeDriver(browser);
		
	}
	
	
	@Test
  public void dragdrop() throws InterruptedException {
	  
	  _driver.get("https://jqueryui.com/droppable/");	 
	  //_driver.findElement(By.tagName("//iframe"));
	   
	  
	  Actions act = new Actions(_driver);
	  
	  Thread.sleep(20000);
	  WebElement frm = _driver.findElement(By.xpath("//iframe"));
	  waitSwitchToFrame(_driver,50,frm);
	  
	  
	  WebElement source = _driver.findElement(By.id("draggable"));
	  WebElement target = _driver.findElement(By.id("droppable"));
	 
	  act.dragAndDrop(source, target);
	  act.build().perform();
	  
  }
}
