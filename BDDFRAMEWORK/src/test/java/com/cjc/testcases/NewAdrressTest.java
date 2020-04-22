package com.cjc.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import com.cjc.pages.NewAddressPage;

import com.cjc.utility.Common;

public class NewAdrressTest {
	@Test
	public void newAddressCheck()
	{
		WebDriver driver=Common.openBrowser("chrome","http://a.testaddressbook.com/sign_in");
		NewAdrressTest test=PageFactory.initElements(driver, NewAdrressTest.class);
		
		//test.signinbutton("gourigove00@gmail.com", "abcd@1234");
		String url1=driver.getCurrentUrl();
		System.out.println(url1);
		 if(url1.equalsIgnoreCase("http://a.testaddressbook.com/addresses"))
			{
				NewAddressPage  newaddpage=PageFactory.initElements(driver, NewAddressPage.class);
				newaddpage.clickNewaddress();
			}
			
	}

	

		
	

}
