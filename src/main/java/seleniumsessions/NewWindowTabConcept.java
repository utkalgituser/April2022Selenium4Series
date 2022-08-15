package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindowTabConcept {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		eutil=new ElementUtil(driver);
		
		// Creates a new window either by Tab or, window. 
		driver.switchTo().newWindow(WindowType.TAB).get("https://www.bigbasket.com/");

		System.out.println(driver.getCurrentUrl());
		driver.close();

	}

}
