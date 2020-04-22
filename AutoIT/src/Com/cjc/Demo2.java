package Com.cjc;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2 {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://smallpdf.com/jpg-to-pdf");
		driver.findElement(By.xpath("//*[@id=\"__cond-23\"]/div/div/div/div/div[2]/form/label/div/div[2]/button[1]")).click();
		Runtime.getRuntime().exec("F:\\Testing_WorkSpace\\Fileupload.au3");
	}


}
