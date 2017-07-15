package com.batch1.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
//import org.openqa.selenium.support.PageFactory;

public class MTHomePage {
	
	WebDriver driver;
	
	
	
	//Object Repository for Mercury tours login Page
	
	//Text boxes
	
	@FindBy(name="userName") WebElement _userName;
	@FindBy(css="input[name=password") WebElement _password;
	
	//Links
	@FindBy(how = How.LINK_TEXT,using="REGISTER") WebElement _register;
	
	//Buttons
	
	@FindBy(xpath="//input[@value='Login']") WebElement _login;
	
	public MTHomePage(WebDriver driver){
		
		this.driver = driver;
		
		//PageFactory.initElements(driver, this);
		
		
		driver.get("http://newtours.demoaut.com/");
	}

	
	
	
	
	public void loginToMercuryTours(String uName, String pwd){
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		_userName.sendKeys(uName);
		_password.sendKeys(pwd);
		_login.click();
		
	}
	
	
	public void clickOnRegister(){
		
		_register.click();
		
	}
	

}
