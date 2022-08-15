package java8TMB;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumsessions.ElementUtil;

public class TestRunner5 {

	static WebDriver driver = null;
	static ElementUtil eutil = null;
	
	public static void main(String[] args) {
		
		List<String> lst=Arrays.asList("Utkal","neel","smita");
		lst.forEach((a)->System.out.println(a));
		System.out.println("--------------");
		
		Consumer<String> consumer= (s) -> System.out.println(s); // ? --> String or super class of String class
		Consumer<String> consumer1= (s) -> System.out.println(s.toUpperCase());
		Consumer<String> consumer2= (s) -> System.out.println(s.toLowerCase());
		lst.forEach(consumer);	
		System.out.println("--------------");
		lst.forEach(consumer.andThen(consumer1).andThen(consumer2));
		System.out.println("--------------");
		

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();

		List<WebElement> eles = driver.findElements(By.tagName("a"));
		Consumer<WebElement> con=(ele) -> System.out.println(ele.getText());
		Consumer<WebElement> con1=(ele) -> {
			if(!ele.getText().isBlank()) {
				System.out.println(ele.getText());
			}
		};
		eles.forEach(con1);
		driver.quit();
		
	}

}
