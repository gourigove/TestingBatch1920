package FbregXml;

import java.sql.Driver;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Fbreg {
	public WebDriver driver;
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\\\Testing\\\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@BeforeTest
	public void enterUrl()
	{
		driver.get("https://www.facebook.com/");
	}
	@AfterClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getCookies()
	{
		System.out.println("get cookies");
		Set<Cookie>se=driver.manage().getCookies();
		int count=se.size();
		for(Cookie cookie:se)
		{
			System.out.println("All"+cookie.getName());
		}
	}
		@Test
		@Parameters({"username","password"})
		public void register(String usename,String password)
		{
			
			driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys(usename);
			driver.findElement(By.xpath("//input[@id=\"pass\"]")).sendKeys(password);
			driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
			//driver.findElement(By.xpath("//input[@id=\"pass\"]")).sendKeys("1234");
			//driver.findElement(By.xpath("button[type=\"submit\"]")).click();

			
		}
		/*@AfterMethod
		public void captureScrrenshot() throws IOException
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("E:\\Second\\fb.jpeg"));
			System.out.println("success");
		}*/
		@AfterClass
		public void deleteCookie()
		{
			driver.manage().deleteAllCookies();
			
		}
		@AfterTest
		public void dbClose() {
			System.out.println("db close");
		}
		@AfterSuite
		public void closeWindow()
		{
			
			driver.close();
		}
		

	}
