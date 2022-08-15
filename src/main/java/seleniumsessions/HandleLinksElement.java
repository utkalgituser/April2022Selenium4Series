package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinksElement {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("https://naveenautomationlabs.com/opencart");
		By macLink=By.linkText("MacBook");
		ElementUtil eleUtil=new ElementUtil(driver);
		eleUtil.doClick(macLink);
		
		Thread.sleep(3000);
		driver.close();
	}

}
