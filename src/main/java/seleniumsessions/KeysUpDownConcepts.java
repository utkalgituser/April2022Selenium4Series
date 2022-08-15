package seleniumsessions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeysUpDownConcepts {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		eutil = new ElementUtil(driver);

		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).sendKeys(Keys.END).sendKeys(Keys.NULL).build().perform();
		Thread.sleep(1000);

		act.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).sendKeys(Keys.NULL).build().perform();
		Thread.sleep(1000);

		driver.quit();
	}

}
