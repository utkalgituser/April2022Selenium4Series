package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessIncogniito {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		// headless:
		// no browser is displayed
		// testing fast

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		// co.setHeadless(true);
		// co.addArguments("--Incognito");

		FirefoxOptions fo = new FirefoxOptions();
		fo.setHeadless(true);

		WebDriver dr = new ChromeDriver(co);
		dr.get("https://naveenautomationlabs.com/opencart/index.php?route=product/product&product_id=33&search=sam+sung");
		System.out.println(dr.getTitle());
		// dr.quit();
		dr.close();
	}

}
