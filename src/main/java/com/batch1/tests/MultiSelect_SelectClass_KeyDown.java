package com.batch1.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.batch1.lib.Config;

public class MultiSelect_SelectClass_KeyDown extends Config{
	WebDriver _driver;
	
	@Parameters("bName")
	@BeforeTest
	public void setup(String browser){
		
		_driver = Config.initializeDriver(browser);	
		
	}
	
	
  @Test
  public void multiSelectBix() throws InterruptedException {
	  
	  _driver.get("file:///F:/Techies/Java/workspace/batch1Advanced/src/main/java/com/batch1/testdata/multiSelect.html");
	  Thread.sleep(10000);
	  Select multibox = new Select( _driver.findElement(By.tagName("select"))); 
	  Actions act = new Actions(_driver);
	  act.keyDown(Keys.CONTROL);
		 
	 multibox.selectByVisibleText("Tomatoes");
	 multibox.selectByVisibleText("Mushrooms");
	 
	 act.keyUp(Keys.CONTROL);
	 
	 
	  
  }
}
