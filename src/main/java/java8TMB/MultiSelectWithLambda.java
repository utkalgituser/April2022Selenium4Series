package java8TMB;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumsessions.ElementUtil;

public class MultiSelectWithLambda {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		// dropdown - must have select dropdown tag
		// use select class from selenium

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		
		List<WebElement> options = new Select(driver.findElement(By.id("cars"))).getOptions();
		// options.forEach(WebElement::click);
		options.stream().skip(2).forEach(WebElement::click);
		Thread.sleep(2000);
		
		
		driver.quit();
	}

}
