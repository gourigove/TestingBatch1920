package IncludeXml;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Include {
	public WebDriver driver;
	@BeforeSuite
	public void openbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\chromedriver.exe");
		driver=new ChromeDriver();
		
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	@Test
	public void enterUrl()
	{
		driver.get("https://www.facebook.com/");
	}
	@Test
	public void maximizePage()
	{
		driver.manage().window().maximize();
		System.out.println("maximize page");
	}
	
	

}
