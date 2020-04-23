package DataproviderMultiple;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleUserDataProvider {
	public WebDriver driver;
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\chromedriver.exe");
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
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void getCookie()
	{
		System.out.println("All cookies");
		Set<Cookie>se=driver.manage().getCookies();
		for(Cookie cookie:se)
		{
			System.out.println("all cookie"+cookie.getPath());
		}
		
	}
	@Test(dataProvider="getdata")
	public void login(String un,String ps)
	{
		driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(ps);
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
		//driver.navigate().back();
		
	}
@AfterMethod
public void capureScrrenShot() throws IOException
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FilUtils.copyFile(src, new File("E:\\Testing\\Scrrenshot.Mercury.jpeg"));
	System.out.println("Sucess");
	}

@AfterClass
public void deleteCookie()
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
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	driver.close();
}
@DataProvider
public Object[][]getdata()
{
	Object [][]data=new Object[4][2];
	data[0][0]="manjusha1";
	data[0][1]="manjusha";
	data[1][0]="manjusha2";
	data[1][1]="manjusha";
	data[2][0]="manjusha3";
	data[2][1]="manjusha";
	data[3][0]="gouri";
	data[3][1]="gove";
	
	return data;
	
	
	}
}















