package Com.cjc;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo3 {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "I:\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://smallpdf.com/jpg-to-pdf");
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[6]/div/div[2]/div/div/div/div/div[2]/form/label/div/div[3]"));
		Runtime.getRuntime().exec("F:\\Testing_WorkSpace\\DemoFile.au3");
	}

}
