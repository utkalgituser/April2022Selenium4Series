package seleniumsessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();

		By footer = By.id("twotabsearchtextbox");
		
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1
		.ignoring(NoSuchElementException.class)
		.pollingEvery(Duration.ofSeconds(1))
		.withMessage("Element not found");
		
		// Fluentwait(C) --> Wait(I) 
		
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
				.withMessage("Element not present... ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(footer)).sendKeys("apple");
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
		driver.quit();
	}

}
