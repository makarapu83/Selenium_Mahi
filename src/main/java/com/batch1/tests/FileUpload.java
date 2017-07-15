package com.batch1.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.batch1.lib.Config;

public class FileUpload extends Config{
	WebDriver _driver;
	
	@Parameters("bName")
	@BeforeTest
	public void setup(String browser){
		
		_driver = Config.initializeDriver(browser);
		
	}
	
  @Test
  public void upload() throws InterruptedException, IOException {
	  
	  _driver.get("	");
	  Thread.sleep(30000);
	 //waitSwitchToFrame(_driver, 50, _driver.findElement(By.xpath("//iframe")));
	  _driver.findElement(By.name("img")).click(); 
	  
	  Runtime.getRuntime().exec("F:/Techies/AutoIt3.exe");
	  
	  
	  
  }
}
