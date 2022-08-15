package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandleCOncepts {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		driver.manage().window().maximize();
		eutil=new ElementUtil(driver);
		
		// driver.switchTo().frame(2);
		driver.switchTo().frame("main");
		// driver.switchTo().frame(driver.findElement(By.tagName("main")));
		System.out.println(driver.findElement(By.tagName("h2")).getText());
		driver.quit();
	}

}
