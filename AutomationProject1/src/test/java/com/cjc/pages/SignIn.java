package com.cjc.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


public class SignIn {
	public WebDriver driver;
	Properties pro=new Properties();
	public SignIn(WebDriver driver)
	{
		this.driver=driver;
	}
	public void SignIn() throws IOException
	{
		FileInputStream fis=new FileInputStream("F:\\Testing_WorkSpace\\Automation\\AutomationProject1\\Parameter.properties");
		pro.load(fis);
		//signin
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		//email
		driver.findElement(By.cssSelector("#email_create")).sendKeys(pro.getProperty("email"));
		//create account
		driver.findElement(By.cssSelector("#SubmitCreate > span")).click();
	}
}