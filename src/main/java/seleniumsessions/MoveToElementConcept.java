package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConcept {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://mrbool.com/");
		driver.manage().window().maximize();
		eutil=new ElementUtil(driver);
		
		By parentMenu=By.className("menulink");
		By childMenu=By.linkText("COURSES");
		
		handleTwoLevelMenuItems(parentMenu, childMenu);
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void handleTwoLevelMenuItems(By parentMenu, By childMenu) throws InterruptedException {
		Actions act=new Actions(driver);
		act.moveToElement(getMenu(parentMenu)).build().perform();
		Thread.sleep(2000);
		getMenu(childMenu).click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	
	public static WebElement getMenu(By locator) {
		return driver.findElement(locator);	
	}
}
