package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitlyWaitConcept {

	static WebDriver driver = null;

	public static void main(String[] args) {

		// 2.b: Explicitly wait
		// 2.b.1: Webdriver wait
		// 2.b.2: Fluent wait

		// for specific webelement only
		// can be applied for non webelements: alerts, url, title

		// webDriverWait(class) --> extends --> FluentWait(class) --> implements -->
		// wait(Interface) --> until(); method
		// All the methods extended from // until()
		// FluentWait // other methods()

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();

		By id = By.id("input-email");
		By pwd = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //
		 * Sel 4 syntax
		 * wait.until(ExpectedConditions.presenceOfElementLocated(id)).sendKeys();
		 * wait.until(ExpectedConditions.presenceOfElementLocated(pwd)).sendKeys(
		 * "utkal@123");
		 * wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn)).click();
		 */

		doSendKeysWithWait(id, 10, "utkal@gmail.com");
		doSendKeys(pwd, "utkal@123");
		doClick(loginBtn);

		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));

		driver.quit();
	}

	public static void doClick(By locator) {
		getElement(locator).click();
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public static void doSendKeysWithWait(By locator, int timeOut, String value) {
		waitForElementPresence(locator, timeOut).sendKeys(value);
	}
	
	
	public static void doClickWithWait(By locator, int timeOut, String value) {
		waitForElementPresence(locator, timeOut).click();
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. This does not
	 * necessarily mean that the element is visible.
	 *
	 * 19-Jul-2022
	 * @author Utkal Barik
	 * @param locator
	 * @param timeOut
	 * @return
	 *
	 */
	public static WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
