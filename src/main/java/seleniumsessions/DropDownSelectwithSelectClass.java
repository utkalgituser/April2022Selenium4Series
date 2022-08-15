package seleniumsessions;

import java.util.List;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSelectwithSelectClass {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		// dropdown - must have select dropdown tag
		// use select class from selenium

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		driver.manage().window().maximize();
		eutil = new ElementUtil(driver);

		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");

		// driver.findElement(country).sendKeys("India");

		doSelectValueUsingOptions(country, "India");
		selectFromDropDown((e)->e.selectByVisibleText("India"), getElement(country));
		Thread.sleep(2000);
		selectFromDropDown((e)->e.selectByVisibleText("Odisha"), getElement(state));
		Thread.sleep(2000);
		driver.quit();
	}
	
	private static void selectFromDropDown(Consumer<Select> consumer, WebElement ele) {
		Select sel=new Select(ele);
		consumer.accept(sel);
	}

	public static void doSelectValueUsingOptions(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for (WebElement e : optionsList) {
			String text=e.getText();
			System.out.println(text);
			if (text.equals("India")) {
				e.click();
				break;
			}
		}
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
}
