package com.cjc.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.cjc.pages.AddressPage;
import com.cjc.pages.SignIn;
import com.cjc.utility.Common;

public class SignInTest {
	@Test
	public void signincheck()
	{
		WebDriver driver=Common.openBrowser("chrome","http://a.testaddressbook.com/sign_in");
		SignIn sign=PageFactory.initElements(driver, SignIn.class);
		SignIn.signinbutton("gourigove00@gmail.com", "abcd@1234");
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		//AddressPage addPage = PageFactory.initElements(driver, AddressPage.class);
		
		if(url.equalsIgnoreCase("http://a.testaddressbook.com/"))
		{
			AddressPage addPage = PageFactory.initElements(driver, AddressPage.class);
			addPage.clickadd();
		
			addPage.newAddress();
		}
	}
		
	}

