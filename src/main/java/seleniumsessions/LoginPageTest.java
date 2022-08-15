package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {
	
	public static void main(String[] args) throws InterruptedException {
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver dr = brUtil.initDriver("chrome");
		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println(brUtil.getPageTitle());
		System.out.println(brUtil.getPageSource());
		System.out.println(brUtil.getPageUrl());

		By emailID = By.id("input-email"); 
		By passwd=By.id("input-password");
		
		ElementUtil eleUtil=new ElementUtil(dr);
		eleUtil.doSendKeys(emailID, "utkal.barik@gmail.com");
		eleUtil.doSendKeys(passwd, "utkal@123");
		
		Thread.sleep(3000);
		brUtil.closeBrowser();
		
		// 2 class for register page with element util
	}
}
