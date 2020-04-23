package FBXmlRegAnnotation;



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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

import com.beust.jcommander.Parameter;

public class Fbreg {
	WebDriver driver;
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("open browser");
		}
	@BeforeTest
	public void enterUrl()
	{
		driver.get("https://www.facebook.com/");
	}
	@BeforeClass
	public void maximizePage()
	{
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void allCookie()
	{
		System.out.println("all cookie");
		Set<Cookie>se=driver.manage().getCookies();
		int count =se.size();
		System.out.println(count);
		for(Cookie Cookie:se)
		{
		 System.out.println("all cookie"+Cookie.getName());
			
		}
	}
		/*@AfterMethod
		public void captureScrrenshot() throws IOException
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("E:\\second\\fb.jpeg"));
			System.out.println("success");
		}*/
		
		
	@Test(priority=2)
	@Parameters({"username","password"})
	public void login(String username,String password)
	{
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[id='u_0_b']")).click();
		driver.navigate().back();
		//driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("1234");
	}
	@Test(priority=1)
	@Parameters({"username1","password1"})
	
	public void loginTest(String username1,String password1)
	{
	driver.findElement(By.id("email")).sendKeys(username1);
	
		
		driver.findElement(By.name("pass")).sendKeys("password1");
	
		driver.findElement(By.cssSelector("input[id='u_0_b']")).click();
	
		
	}
	
	
	 @AfterTest
	  public void dbClose() {
		  System.out.println("db close");
		  
	  }

	 @AfterSuite
	  public void closeWindow() {
	driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
	driver.close();
	  }


		
		
	
	
	
}
