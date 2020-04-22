package com.cjc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddressPage {
	public WebDriver driver;
	public AddressPage(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(xpath="//*[@id=\"navbar\"]/div[1]/a[2]")
	@CacheLookup
	WebElement addressLink;
	public void clickadd()
	{
		addressLink.click();
	}
	
	@FindBy(how=How.XPATH,using="/html/body/div/a")
	@CacheLookup
	WebElement newaddress;
	public void newAddress()
	{
		newaddress.click();
	}
	
	
	
	
}

	


