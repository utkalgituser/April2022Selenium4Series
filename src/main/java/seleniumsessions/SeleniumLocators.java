package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumLocators {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		String emailID = "input-email"; 
		String passwd="input-password";
		
		String email_name = "email"; 
		String passwd_name="password";
		String loginBtnXpath="//*[@id=\"content\"]/div/div[2]/div/form/input";
		
		ElementUtil eleUtil=new ElementUtil(driver);
		/*
		 * eleUtil.doSendKeys("id", emailID, "utkal.barik@gmail.com");
		 * eleUtil.doSendKeys("id", passwd, "utkal@123");
		 */
		
		eleUtil.doSendKeys("id", emailID, "utkal.barik@gmail.com");
		eleUtil.doSendKeys("name", passwd_name, "utkal@123");
		eleUtil.doClick("xpath", loginBtnXpath);
		
		
		Thread.sleep(3000);
		driver.quit();
	}

}
