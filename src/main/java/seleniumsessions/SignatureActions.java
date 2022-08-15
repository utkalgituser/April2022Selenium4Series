package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.google.common.util.concurrent.Uninterruptibles;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignatureActions {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://cocosign.com/signature-generator/draw/");
		driver.manage().window().maximize();
		eutil = new ElementUtil(driver);

		WebElement canvas = driver.findElement(By.id("signature-pad"));
		Actions act = new Actions(driver);
		
		Action signatureAction=act.click(canvas)
			.moveToElement(canvas, 3, 3).clickAndHold(canvas)
			.moveToElement(canvas, 50, 50)
			.moveByOffset(50, -50)
			.moveByOffset(3,3)
			.release(canvas)
			.build();
		signatureAction.perform();
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
		driver.quit();
	}

}
