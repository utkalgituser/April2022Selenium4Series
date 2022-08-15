package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaiitForAlert {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		eutil=new ElementUtil(driver);
		
		driver.findElement(By.name("proceed")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		String text=wait.until(ExpectedConditions.alertIsPresent()).getText();
		System.out.println(text);
		
		driver.quit();
	}

}
