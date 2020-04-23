package MercurySinup;

import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderMercury {
	public WebDriver driver;
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@BeforeTest
	public void enterUrll()
	{
		driver.get("http://newtours.demoaut.com/");
	}
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getCookies()
	{
		System.out.println("all cookie");
		Set<Cookie>se=driver.manage().getCookies();
		int count=se.size();
		for(Cookie cookie:se)
		{
			System.out.println("all cookie"+cookie.getName());
		}
	}
	@Test(dataProvider="getdata")
	public void login(String un,String ps)
	{
		driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(ps);
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
		driver.navigate().back();
	}
	@Test(dataProvider="getdata")
	public void login1(String un1,String ps1)
	{
		driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys(un1);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(ps1);
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
		driver.navigate().back();
	}
/*	@AfterMethod
	public void captureScrrenShot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Testing\\MercuryS.mercury.jpeg"));
	}*/
	@AfterClass
		public void deleteCookies()
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
	@DataProvider
	public Object[][]getdata()
	{
		Object[][]data=new Object[2][2]; 
		data[0][0]="manjusha1";
		data[0][1]="manjusha";
		data[1][0]="manjusha2";
		data[1][1]="manjusha";
		
		return data;
	}
}

	


