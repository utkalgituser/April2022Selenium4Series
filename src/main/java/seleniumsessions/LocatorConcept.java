package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {
	public static WebDriver dr=null;
	
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		dr=new ChromeDriver();
		dr.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		/*
		 * dr.findElement(By.id("input-email")).sendKeys("utkal.barik@gmail.com");
		 * dr.findElement(By.id("input-password")).sendKeys("utkal@123");
		 */
		
		/*
		 * WebElement emailID= dr.findElement(By.id("input-email")); WebElement passwd=
		 * dr.findElement(By.id("input-password"));
		 * 
		 * emailID.sendKeys("utkal.barik@gmail.com"); passwd.sendKeys("utkal@123");
		 */
		
		/*
		 * By emailID = By.id("input-email"); By passwd=By.id("input-password");
		 * dr.findElement(emailID).sendKeys("utkal.barik@gmail.com");
		 * dr.findElement(passwd).sendKeys("utkal@123");
		 */

		
		/*
		 * getElement(emailID).sendKeys("utkal.barik@gmail.com");
		 * getElement(passwd).sendKeys("utkal@123");
		 */
		
		String email_id="input-email";
		String password_id="input-password";
		
		doSendKeys("id",email_id, "utkal.barik@gmail.com");
		doSendKeys("id",password_id, "utkal@123");
	}
	
	public static By getBy(String locatorType, String selector) {

		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(selector);
			break;

		case "class":
			locator = By.className(selector);
			break;

		case "xpath":
			locator = By.xpath(selector);
			break;
			
		default:
			break;
		}
		return locator;
	}
	
	public static void doSendKeys(String locatorType, String selector, String value) {
		By locator = getBy(locatorType, selector);
		getElement(locator).sendKeys(value);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static WebElement getElement(By locator) {
		return dr.findElement(locator);
	}
}
