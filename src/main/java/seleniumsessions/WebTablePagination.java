package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablePagination {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		eutil = new ElementUtil(driver);

		WebElement nextBtn = driver.findElement(By.linkText("Next"));
		String singleCityCoubtry = "Denmark";
		selectCity(singleCityCoubtry);

		Select sel = new Select(driver.findElement(By.name("tablepress-1_length")));
		sel.selectByVisibleText("100");
		Thread.sleep(2000);
		String multiCityCoubtry = "United States";
		driver.findElement(By.xpath("//div[@id='tablepress-1_filter']//input[@type='search']"))
				.sendKeys(multiCityCoubtry, Keys.ENTER);
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//td[text()='" + multiCityCoubtry + "']"));
		System.out.println(list.size());
		while (true) {
			if (!list.isEmpty()) {
				selectMultiCity(multiCityCoubtry, list.size());
				break;
			} else {
				nextBtn.click();
			}
		}
		Thread.sleep(2000);
		driver.quit();
		// select all those check boxes with US
	}
	
	// try with multiple country as India, USA
	
	public static void selectMultiCity(String countryName, int size) throws InterruptedException {
		for (int i = 1; i <= size; i++) {
			driver.findElement(By.xpath("(//td[text()='" + countryName + "']/preceding-sibling::td/input)[" + i + "]"))
					.click();
			Thread.sleep(3000);
		}
	}

	public static void selectCity(String countryName) {
		driver.findElement(By.xpath("//td[text()='" + countryName + "']/preceding-sibling::td/input")).click();
	}

}
