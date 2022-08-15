package java8TMB;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {

	static WebDriver driver = null;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();

		List<String> text = new ArrayList<>();
		List<WebElement> eles = driver.findElements(By.tagName("a"));
		eles.stream()
		.map(WebElement::getText)
		.filter(s -> !s.isBlank())
		.distinct()
		.sorted()
		.filter(s -> s.startsWith("T"))
		.forEach(System.out::println);
		
		driver.quit();
	}

}
