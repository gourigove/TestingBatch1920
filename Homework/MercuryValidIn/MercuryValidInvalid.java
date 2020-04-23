package MercuryValidIn;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MercuryValidInvalid {
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
		//driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
		driver.navigate().back();
	}
	@Parameters({"username1","password1"})
	@Test
	public void login1(String username1,String password1)
	{
		//driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username1);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password1);
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
		driver.navigate().back();
	}
	@Parameters({"username2","password2"})
	@Test
	public void login3(String username2,String password2)
	{
		//driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username2);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password2);
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
	}
	@AfterMethod
	public void captureScrrenShot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("E:\\Screenshot\\fb.jpeg"));
		System.out.println("Success");
	}
	@AfterClass
	public void deleteCookies()
	{
		driver.manage().deleteAllCookies();
	}
	@AfterTest
	public void dbClose()
	{
		System.out.println("db close");
	}
	@AfterSuite
	public void closeWindow()
	{
		driver.close();
		//driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
	

}
