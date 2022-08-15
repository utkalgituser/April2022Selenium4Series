package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.base.Strings;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.util.List;
import java.util.Objects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.aqi.in/dashboard/india");
		driver.manage().window().maximize();
		eutil = new ElementUtil(driver);

		WebElement baseEle = driver.findElement(By.linkText("Kulu, India"));
		System.out.println(driver.findElement(with(By.tagName("p")).toRightOf(baseEle)).getText());
		System.out.println(driver.findElement(with(By.tagName("p")).toLeftOf(baseEle)).getText());

		System.out.println(driver.findElement(with(By.tagName("p")).below(baseEle)).getText());
		System.out.println(driver.findElement(with(By.tagName("p")).above(baseEle)).getText());
		System.out.println("near " + driver.findElement(with(By.tagName("p")).near(baseEle)).getText());
		List<WebElement> eles = driver.findElements(with(By.tagName("p")).above(baseEle));
		for (WebElement e : eles) {
			if (Strings.isNullOrEmpty(e.getText())) {
				System.out.println(e.getText());
			}
		}
		driver.quit();
	}

}
