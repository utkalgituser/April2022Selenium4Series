package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.util.concurrent.Uninterruptibles;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeysConcept {

	static WebDriver driver = null;
	
	
	// NOT WORKING WITH SELENIUM 4
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.name("q"));
		Actions act=new Actions(driver);
		// send keys in caps letter
		act.keyDown(ele, Keys.SHIFT).sendKeys("utkal").sendKeys(Keys.NULL).build().perform();
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
		// act.keyDown(Keys.CONTROL).sendKeys("r").keyUp(Keys.CONTROL).build().perform();
		
		// act.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).build().perform();
		
		act.sendKeys(Keys.chord(Keys.CONTROL, Keys.F5)).build().perform();
		
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
		driver.quit();
	}

}
