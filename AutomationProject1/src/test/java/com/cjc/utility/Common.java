package com.cjc.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common {
	static WebDriver driver;

	 public static WebDriver openBrowser(String browsername,String urlname)
	 {
	 	if(browsername.equalsIgnoreCase("chrome"))
	    {
	 	System.setProperty("webdriver.chrome.driver", "I:\\\\chromedriver.exe");
	      driver=new ChromeDriver();
	 }
	 	driver.manage().window().maximize();
	 	driver.get(urlname);
	 	return driver;
	 	
	 }

}

	


