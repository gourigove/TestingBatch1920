package com.cjc.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.cjc.pages.SignIn;
import com.cjc.utility.Common;

public class SignTest {
	@Test
	public void verify() throws IOException
	{
		WebDriver driver=Common.openBrowser("chrome","http://automationpractice.com/index.php?controller=authentication&back=my-account");
		SignIn a=new SignIn(driver);
		a.SignIn();
		String url=driver.getCurrentUrl();
		System.out.println(url);
	}

}
