package seleniumsessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitFOrElements {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) {
		long stTime=System.currentTimeMillis();
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		eutil = new ElementUtil(driver);

		By footer = By.cssSelector("div.navFooterLinkCol li a");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footer));

		list.stream()
			.map(WebElement::getText)
			.forEach(System.out::println);
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-stTime);
		driver.quit();
	}
}
