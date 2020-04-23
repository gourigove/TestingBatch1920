package DragDrop;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\\\Testing\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://javascript.info/mouse-drag-and-drop");
		driver.manage().window().maximize();
		List<WebElement>ls=driver.findElements(By.tagName("iframe"));
		int count=ls.size();
		System.out.println(count);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
       driver.switchTo().frame(4);
		WebElement src=driver.findElement(By.xpath("//img[@id='ball']"));
		WebElement target=driver.findElement(By.xpath("//img[@id='gate']"));
		Actions action=new Actions(driver);
		action.dragAndDrop(src, target).build().perform();
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("About")).click();
		
	}

}
