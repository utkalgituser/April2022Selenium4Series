package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickAndSendKeys {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		eutil=new ElementUtil(driver);
		
		By id=By.id("input-email");
		By pwd=By.id("input-password");
		By loginBtn=By.xpath("//input[@value='Login']");
		
		Actions act=new Actions(driver);
		doActionsSendKeys(id, "utkal@gmail.com");
		doActionsSendKeys(pwd, "utkal@123");
		doActionsClick(loginBtn);
		
		Thread.sleep(3000);
		driver.quit();
	}
	
	public static void doActionsSendKeys(By locator, String value) {
		Actions act=new Actions(driver);
		act.sendKeys(getMenu(locator), value).build().perform();
	}
	
	public static void doActionsClick(By locator) {
		Actions act=new Actions(driver);
		act.click(getMenu(locator)).perform();
	}
	
	public static WebElement getMenu(By locator) {
		return driver.findElement(locator);
	}
}
