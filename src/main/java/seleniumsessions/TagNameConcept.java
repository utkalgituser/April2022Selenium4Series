package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TagNameConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.orangehrm.com/");
		
		By contactSales=By.xpath("//li[@class='ex-nav']/a");
		ElementUtil eleutil=new ElementUtil(driver);
		System.out.println(eleutil.doElementGetText(contactSales));

		driver.close();
	}

}
