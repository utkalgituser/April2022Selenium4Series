package seleniumsessions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsRefreshPages {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		eutil = new ElementUtil(driver);
		System.out.println(driver.getCurrentUrl());
		Actions act = new Actions(driver);

		// Performs a modifier key press. Does not release the modifier key - subsequent
		// interactionsmay assume it's kept pressed.Note that the modifier key is never
		// released implicitly - either keyUp(theKey) or sendKeys(Keys.NULL)must be
		// called to release the modifier.
		act.keyDown(Keys.CONTROL).sendKeys("r").keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());

		act.keyDown(Keys.CONTROL).sendKeys(Keys.F5).sendKeys(Keys.NULL).build().perform();
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());

		driver.quit();
	}

}
