package com.RegMercuryXml;



import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class regMercury {
	public  WebDriver driver;
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@BeforeTest
	public void enterUrl()
	{
		driver.get("http://www.newtours.demoaut.com/");
	}
	@BeforeClass
	public void maximizePage()
	{
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getCookies()
	{
		System.out.println("all cookie");
		Set<Cookie>se=driver.manage().getCookies();
	int count=se.size();
		System.out.println("all cookies");
		for(Cookie cookie:se)
		{
			System.out.println("all cookie"+cookie.getDomain());
		}
	}
	@Test
public void login()
{
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]")).sendKeys();
	}
}
