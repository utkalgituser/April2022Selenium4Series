package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForTitle {

	static WebDriver driver = null;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Registry")).click();
		String title=waitForTitleContains(5, "Registry");
		System.out.println(title);

		driver.quit();
	}

	public static String waitForTitleContains(int timeOut, String titlePartValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (Boolean.TRUE.equals(wait.until(ExpectedConditions.titleContains(titlePartValue)))) {
			return driver.getTitle();
		} else {
			System.out.println("Title not found...");
			return null;
		}
	}
}
