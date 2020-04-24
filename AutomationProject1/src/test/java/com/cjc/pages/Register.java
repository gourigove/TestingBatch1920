package com.cjc.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Register {
	public WebDriver driver;
	Properties pro=new Properties();
	public Register(WebDriver driver)
	{
		this.driver=driver;
	}
	public void verifyRegister() throws IOException
	{
		system.out.println("Git changes");
	FileInputStream fis=new FileInputStream("F:\\Testing_WorkSpace\\Automation\\AutomationProject1\\Parameter.properties");
	pro.load(fis);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//title radio button
	driver.findElement(By.xpath("//*[@id=\"id_gender2\"]")).click();
	
    //Firstname
	driver.findElement(By.cssSelector("#customer_firstname")).sendKeys(pro.getProperty("Firstname"));
	
	//Lastname
	driver.findElement(By.xpath("//input[@id=\"customer_lastname\"]")).sendKeys(pro.getProperty("Lastname"));
	
	//password
	driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(pro.getProperty("password"));

	//date
	 WebElement brith=driver.findElement(By.xpath("//*[@id=\"days\"]"));
	 Select day=new Select(brith);
	 day.selectByIndex(3);
	 //month
	 WebElement month=driver.findElement(By.xpath("//*[@id=\"months\"]"));
	 Select s=new Select(month);
	 s.selectByIndex(4);
	  //year
	 WebElement year=driver.findElement(By.xpath("//*[@id=\"years\"]"));
	 Select s2=new Select(year);
	 s2.selectByIndex(3);
      //company
	driver.findElement(By.cssSelector("#company")).sendKeys(pro.getProperty("Company"));

	//address
	driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(pro.getProperty("Address"));
    //city
	
	driver.findElement(By.id("city")).sendKeys("City");
	 
     //State
	
	 WebElement br1=driver.findElement(By.id("id_state"));
	 Select s1=new Select(br1);
	 s1.selectByIndex(31);
	
	//postalcode
	driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys(pro.getProperty("Zip/PostalCode"));

	//Country
	 WebElement br=driver.findElement(By.cssSelector("select[id='id_country']"));
	 Select s3=new Select(br);
	 s3.selectByIndex(1);


	//mobile no
	driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys(pro.getProperty("Mobilephone"));

	//Address
	driver.findElement(By.xpath("//*[@id=\"alias\"]")).sendKeys(pro.getProperty("Assignanaddressaliasforfuturereference"));
	//Register
	driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();


}
}
	


