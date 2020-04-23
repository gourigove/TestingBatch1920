package MercurySinup;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mercury {
	public WebDriver driver;
	@BeforeSuite
	public void openUrl()
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
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getCookies()
	{
		System.out.println("all cookies");
		Set<Cookie>se=driver.manage().getCookies();
		int count=se.size();
		for(Cookie cookie:se)
		{
			System.out.println("all cookie"+cookie.getDomain());
		}
	}
	@Test
	public void login()
	{
		driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys("manjusha1");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("manjusha1");
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys("manjusha1");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("manjusha");
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
	}
	
	
	

}
