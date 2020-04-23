package com.cjc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class Register {
	public WebDriver driver;
	public Register (WebDriver driver)
	{
		this.driver=driver;
	}
	//Firstname
	@FindBy(how=How.XPATH,using ="//input[@name='firstName']")
	@CacheLookup
	WebElement firstname;
	//lastname
	@FindBy(how=How.XPATH,using ="//input[@name='lastName']")
	@CacheLookup
WebElement lastname;	
	
	//phone
	@FindBy(how=How.XPATH,using ="//input[@name='phone']")
	WebElement phone;
	
	//Email
	@FindBy(how=How.XPATH,using="//input[@id='userName']")
	WebElement email;
	//address
	@FindBy(how=How.XPATH,using="//input[@name='address1']")
    WebElement	address;
	//City
	@FindBy(how=How.XPATH,using="//input[@name='city']")
   WebElement city;
	//State
	@FindBy(how=How.XPATH,using="//input[@name='state']")
	WebElement state;
	//postal code
	@FindBy(how=How.XPATH,using="//input[@name='postalCode']")
   WebElement postalcode;
	//country
	@FindBy(how=How.XPATH,using="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select")
	WebElement country;
	//username
	@FindBy(how=How.XPATH,using="//input[@name='email']")
	WebElement username;
	//password
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	WebElement password;
	//cpassword
	@FindBy(how=How.XPATH,using="//input[@name='confirmPassword']")
	WebElement cpassword;
	//submit
	@FindBy(how=How.XPATH,using="//input[@name='register']")
	WebElement submit;
	
	public void regcheck(String first,String last,String pho,String email1,String addrs,String city1,String state1,String poc,String country1,String uname,String pass,String cpass)
	{
		firstname.sendKeys(first);
		lastname.sendKeys(last);
		phone.sendKeys(pho);
		email.sendKeys(email1);
		firstname.sendKeys(addrs);
		city.sendKeys(city1);
		state.sendKeys(state1);
		postalcode.sendKeys(poc);
		country.sendKeys(country1);
		username.sendKeys(uname);
		password.sendKeys(pass);
		cpassword.sendKeys(cpass);
		submit.click();

	}
	
}
