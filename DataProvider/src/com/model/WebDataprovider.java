package com.model;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.grid.internal.exception.NewSessionException;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WebDataprovider {
	WebDriver driver;
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@BeforeTest
	public void enterUrl()
	{
		driver.get("http://demowebshop.tricentis.com/camera-photo");
		
	}
	@BeforeClass
	public void maximizePage()
	{
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getCookies()
	{
		Set<Cookie>se=driver.manage().getCookies();
		for(Cookie cookie:se)
		{
			System.out.println("All cookie"+cookie.getDomain());
		}
	}
	@AfterMethod
	public void captureScreenShot() throws IOException
	{
		
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("F:\\selenium\\screen.jpeg"));
}
@Test(dataProvider="getdata",priority=1)
public void login(String firstname,String lastname,String email,String password,String cpassword)
{
	driver.findElement(By.linkText("Register")).click();
WebElement gender=driver.findElement(By.id("gender-female"));
boolean flag=gender.isSelected();
System.out.println(flag);
gender.click();
driver.findElement(By.id("FirstName")).sendKeys(firstname);
driver.findElement(By.id("LastName")).sendKeys(lastname);
driver.findElement(By.id("Email")).sendKeys(email);
driver.findElement(By.id("Password")).sendKeys(password);
driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys(cpassword);
driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
//driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[2]/input")).click();
//driver.navigate().back();
}
   

@DataProvider
public Object[][] getdata()
{
	Object[][] data= new Object[2][5];
	data[0][0]="gouri";
	data[0][1]="gove";
	data[0][2]="gourigov@gmail.com";
	data[0][3]="123456";
	data[0][4]="123456";
	return data;
	
	
}
	
	
	
	
}


