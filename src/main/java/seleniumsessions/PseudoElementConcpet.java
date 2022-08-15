package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PseudoElementConcpet {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.manage().window().maximize();
		eutil = new ElementUtil(driver);
		
		

		JavascriptExecutor js=(JavascriptExecutor)driver;
		System.out.println(js.executeScript("return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"),'::before').getPropertyValue('content')".toString()));
		System.out.println(js.executeScript("return window.getComputedStyle(document.querySelector(\"label[for='input-lastname']\"),'::before').getPropertyValue('content')".toString()));
		System.out.println(js.executeScript("return window.getComputedStyle(document.querySelector(\"label[for='input-email']\"),'::before').getPropertyValue('content')".toString()));
		driver.quit();
	}

}
