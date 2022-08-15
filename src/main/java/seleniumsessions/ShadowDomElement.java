package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomElement {


	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		eutil=new ElementUtil(driver);
		
		driver.switchTo().frame("pact");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement ele = (WebElement)js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
		ele.sendKeys("masala tea");
		driver.quit();
		
		
	}

}
