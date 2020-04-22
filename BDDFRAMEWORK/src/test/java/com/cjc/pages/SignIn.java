package com.cjc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignIn {
	WebDriver driver;
	public SignIn( WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(id="session_email")
	static
	WebElement username;
	//Dynamic
	@FindBy(how=How.ID,using="session_password")
	@CacheLookup
	static
	WebElement password;
	@FindBy(how=How.NAME,using ="commit")
	@CacheLookup
	static
	WebElement signinbutton;
	
	public static  void signinbutton(String uid,String pass)
	{
		username.sendKeys(uid);
		password.sendKeys(pass);
		signinbutton.click();
	}
	


}
