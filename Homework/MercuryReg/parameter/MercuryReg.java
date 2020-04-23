package MercuryReg.parameter;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MercuryReg {
	public WebDriver driver;
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\\\Testing\\\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@BeforeTest
	public void openUrl()
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
		System.out.println("All cookies");
		Set<Cookie>se=driver.manage().getCookies();
		for(Cookie cookie:se)
		{
			System.out.println("All cookies"+cookie.getDomain());
		}
	}
	@Parameters({"username","password"})
	@Test
	public void login(String username,String password)
	{
		
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
		driver.navigate().back();
	}
	@Parameters({"username1","password1"})
	@Test
	public void login1(String username1,String password1)
	{
		
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username1);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password1);
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
		driver.navigate().back();
	}
	@Parameters({"username2","password2"})
	@Test
	public void log(String username2,String password2)
	{
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username2);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password2);
		driver.findElement(By.xpath("//input[@name=\\\"login\\\"]")).click();

	}
}
