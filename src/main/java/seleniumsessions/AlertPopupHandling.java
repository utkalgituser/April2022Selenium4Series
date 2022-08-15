package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopupHandling {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		System.out.println(driver.getTitle());

		driver.findElement(By.name("proceed")).click();
		Thread.sleep(2000);
		
		Alert alert=driver.switchTo().alert(); // JS script alert: alert, confirm, prompt alerts.
		// NoAlertPresentException: no such alert - if alert not present on the page
		
		System.out.println(alert.getText());
		// alert.accept(); //accept the alert
		alert.dismiss(); // dismiss alert
		
		// alert.sendKeys("testing");
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
