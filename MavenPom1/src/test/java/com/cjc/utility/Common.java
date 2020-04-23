package com.cjc.utility;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Common {
	static WebDriver driver;
	@BeforeSuite
	public static WebDriver openBrowser(String browsername,String urlname)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		   {
			System.setProperty("webdriver.chrome.driver", "F:\\\\jar files\\\\chromedriver.exe");
		     driver=new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.get(urlname);
		return driver;
		
	}
		}
	
		


