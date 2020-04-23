package com.cjc;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Test {
	@BeforeSuite
	  public void beforeSuite()
	{
		System.out.println("beforeSuite");
	  }
	 @BeforeTest
	  public void beforeTest() 
	 {
		 System.out.println("before Test");
	  }
	 @org.testng.annotations.Test
	 public void Test()
	 {
		 System.out.println("test");
	 }
	 @BeforeClass
	  public void beforeClass() 
	 {
		 System.out.println("before Class");
	  }
	 @BeforeMethod
	  public void beforeMethod() 
	 {
		 System.out.println("before Method");
	  }

	  @AfterClass
	  public void afterClass() 
	  {
		  System.out.println("after class");
	  }
	  @AfterMethod
	  public void afterMethod() 
	  {
		  System.out.println();
	  }
    @AfterTest
     public void afterTest() 
    {
    	System.out.println("after test");
     }

 @AfterSuite
  public void afterSuite() 
  {
	  System.out.println("after suite");
  }

}
