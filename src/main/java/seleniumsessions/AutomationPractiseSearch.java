package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationPractiseSearch {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		eutil=new ElementUtil(driver);
		
		System.out.println(driver.getCurrentUrl());
		By asideColumn=By.id("column-right");
		System.out.println(eutil.doElementGetText(asideColumn));
		
		driver.quit();
	}

}
