package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableCheckBox {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		eutil=new ElementUtil(driver);
		
		clickOnCheckBox("Joe.Root");
		clickOnCheckBox("Kevin.Mathews");
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void clickOnCheckBox(String name) {
		driver.findElement(
				By.xpath("//a[text()='" + name + "']/parent::td/preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}
}
