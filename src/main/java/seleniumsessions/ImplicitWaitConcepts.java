package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitConcepts {

	static WebDriver driver = null;
	static ElementUtil eutil = null;
	
	public static void main(String[] args) {


		// Dynamic wait: 
		// Implict wait: GLOBAL wait: will be applied for all web elements ONLY
		// its only applicable for webelements
		// not applicable for non webelements: alerts, url, title
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		WebElement mac = driver.findElement(By.linkText("MacBook"));
		System.out.println(mac.getText());
		mac.click();
		driver.quit();
		
	}

}
