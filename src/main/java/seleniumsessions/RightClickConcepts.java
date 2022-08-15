package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcepts {
	// context click - concepts
	
	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		eutil = new ElementUtil(driver);

		WebElement rightClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions act = new Actions(driver);
		act.contextClick(rightClickEle).build().perform();

		List<WebElement> rightEls = driver.findElements(By.xpath("//li[contains(@class,'context-menu-icon')]"));
		for (WebElement e : rightEls) {
			System.out.println(e.getText());
			if (e.getText().equals("Copy")) {
				e.click();
				break;
			}
		}
		Thread.sleep(1000);
		driver.quit();
	}

}
