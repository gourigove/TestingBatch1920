package dataproviderMercurySinup;

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

public class MercurySinup {
	WebDriver driver;
	@BeforeSuite
	
	public void openbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\chromedriver.exe");
	 driver=new ChromeDriver();
	}
	@BeforeTest
	public void openUrl()
	{
		driver.get("http://newtours.demoaut.com/");
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
	
	@Test(dataProvider="getdata")
	public void login(String username,String password)
	{
		
		driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
		driver.navigate().back();
	}
	@Test(dataProvider="getdata")
	public void login1(String username1,String password1)
	{
		//driver.findElement(By.linkText("SIGN-ON"));
		driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys(username1);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password1);
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
		
	}
	/*@AfterMethod
	public void captureScreenShot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Testing\\MercuryS.mercury.jpeg"));
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
		//driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.close();
	}
	@DataProvider
	public Object[][]getdata()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="manjusha1";
		data[0][1]="manjusha";
		data[1][0]="manjusha2";
		data[1][1]="manjusha";
		return data;
		
	}
	

}
