package com.cjc.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class registertestcase {
	public WebDriver driver;
	Properties pro=new Properties();
	Properties pro1=new Properties();
	@BeforeSuite
	public void openbrowser()
	{
		System.out.println("open browser");
	    System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
	   driver=new ChromeDriver();
	  
	}
	@BeforeTest
	public void enterurl() throws IOException
	{
		System.out.println("open url");
		FileInputStream fis=new FileInputStream("F:\\Testing_WorkSpace\\Automation\\BDDFRAMEWORK\\src\\test\\java\\com\\cjc\\utility\\Common.properties");
		pro.load(fis);
		driver.get("http://a.testaddressbook.com/addresses/new");
		
}
	@AfterClass
	public void maximizePage()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void cookies()
	{
		System.out.println("all cookies");
		Set<Cookie>se=driver.manage().getCookies();
		for(Cookie cookie:se)
		{
			System.out.println("All cookie"+cookie.getName());
		}
		
	}
	@Test
	public void Register() throws IOException
	{
		FileInputStream fis=new FileInputStream("F:\\Testing_WorkSpace\\Automation\\BDDFRAMEWORK\\src\\test\\java\\com\\cjc\\utility\\Parameter.properties");
		pro1.load(fis);
	  //Emai ID
		WebElement em=driver.findElement(By.xpath("//input[@id='session_email']"));
	       em.sendKeys("gourigove00@gmail.com");
	   //password
    	WebElement pass=driver.findElement(By.xpath("//input[@id='session_password']"));			
	    pass.sendKeys("abcd@1234");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	// Firstname
	    driver.findElement(By.xpath("//*[@id=\"address_first_name\"]")).sendKeys(pro1.getProperty("Firstname"));
	    
	    //lastname
		driver.findElement(By.xpath("//input[@id=\"address_last_name\"]")).sendKeys(pro1.getProperty("Lastname"));
		
	    //address1	
		driver.findElement(By.xpath("//input[@id=\"address_street_address\"]")).sendKeys(pro1.getProperty("Address1"));
		
		//Address2
		driver.findElement(By.xpath("//input[@id=\"address_secondary_address\"]")).sendKeys(pro1.getProperty("Address2"));
		
		//City
		driver.findElement(By.xpath("//input[@id=\"address_city\"]")).sendKeys(pro1.getProperty("City"));
		
		//State
		WebElement st=driver.findElement(By.xpath("//*[@id=\"address_state\"]"));
		Select s=new Select(st);
		s.selectByIndex(14);
		
		//Zipcode
		driver.findElement(By.xpath("//*[@id=\"address_zip_code\"]")).sendKeys(pro1.getProperty("Zipcode"));
		
		//Country
		driver.findElement(By.name("address[country]")).click();
	  
	    //Bithday
		WebElement birth=driver.findElement(By.xpath("//*[@id=\"address_birthday\"]"));
		birth.sendKeys("12/june/2010");
		
		//Color
	    WebElement color=driver.findElement(By.xpath("//*[@id=\"address_color\"]"));
	    color.sendKeys("red");
	    
	    //Age
	    WebElement age=driver.findElement(By.xpath("//*[@id=\"address_age\"]"));
	    age.sendKeys("23");
	    
	 //Website
		driver.findElement(By.xpath("//*[@id=\"address_website\"]")).sendKeys(pro1.getProperty("Website"));
		
		//File upload
		driver.findElement(By.xpath("//input[@name=\"address[picture]\"]")).sendKeys("F:\\Testing_WorkSpace\\Fileupload.html");
		//Runtime.getRuntime().exec("F:\\Testing_WorkSpace\\DemoFile.au3");
		
		//phone
		driver.findElement(By.xpath("//*[@id=\"address_phone\"]")).sendKeys(pro1.getProperty("Phone"));
		
		//Common Interest
		WebElement checkbox=driver.findElement(By.xpath("//input[@id=\"address_interest_climb\"]"));
		checkbox.click();
		boolean flag1=checkbox.isSelected();
		System.out.println(flag1);
		//Note
        driver.findElement(By.xpath("//*[@name=\"address[note]\"]")).sendKeys(pro1.getProperty("Note"));
        //create address
     // driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
     // driver.findElement(By.className("btn btn-primary")).click();
        driver.findElement(By.cssSelector("#new_address > div.form-group.row.justify-content-center > input")).click();
       

		}
	}

