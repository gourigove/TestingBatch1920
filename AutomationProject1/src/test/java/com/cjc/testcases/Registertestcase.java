package com.cjc.testcases;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.cjc.pages.Register;
import com.cjc.pages.SignIn;
import com.cjc.utility.Common;

public class Registertestcase {
	
	
	@Test
	public void verifyreg() throws IOException 
	{
		WebDriver driver=Common.openBrowser("chrome","http://automationpractice.com/index.php?controller=authentication&back=my-account");
		SignIn s=new SignIn(driver);
		s.SignIn();
		Register  a=new Register(driver);
		a.verifyRegister();
		String url=driver.getCurrentUrl();
		System.out.println(url);

	}

}
