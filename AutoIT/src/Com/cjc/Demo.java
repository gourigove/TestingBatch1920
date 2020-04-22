package Com.cjc;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "F:\\\\\\\\jar files\\\\\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///F:/Testing_WorkSpace/Fileupload.html");
		driver.findElement(By.cssSelector("body > input[type=file]")).click();
		//Runtime.getRuntime().exec("C:\\Users\\Dell\\Desktop\\AutoIT\\Fileupload.exe");
	}

}
