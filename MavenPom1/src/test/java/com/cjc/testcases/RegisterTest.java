package com.cjc.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.cjc.pages.Register;
import com.cjc.utility.Common;

public class RegisterTest {
	//public static WebDriver driver;
	@Test
	public void regcheck() throws IOException
	{
		WebDriver driver=Common.openBrowser("chrome","http://newtours.demoaut.com/mercuryregister.php?");
		Register reg=PageFactory.initElements(driver, Register.class);
		reg.regcheck("gouri", "gove", "76767677778", "gourigove123@gmail.com", "Karvenagar", "Pune", "Maharashtra", "12334","india","gourigove123@gmail.com", "1234", "1234");
	
          File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("F:\\Testing_WorkSpace\\Screenshot\\mercury.jpeg"));
		//FileUtils.copyFile(src, new File("E:\\Testing\\MercuryS.mercury.jpeg"));

	
	}

}
