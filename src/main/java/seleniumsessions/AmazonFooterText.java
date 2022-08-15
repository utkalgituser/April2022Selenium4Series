package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonFooterText {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		eutil=new ElementUtil(driver);
		
		System.out.println(getHeaderValue("Careers"));
		// System.out.println(getHeaderValue("Facebook"));
		System.out.println(getHeaderValue("Sell under Amazon Accelerator"));
		System.out.println(getHeaderValue("COVID-19 and Amazon"));
		driver.quit();
		
		// for https://www.orangehrm.com/orangehrm-30-day-trial/
		//label[text()='Full Name']/..//input[@placeholder='Full Name']
	}
	
	public static String getHeaderValue(String footerLinkText) {
		return driver.findElement(By.xpath("//a[text()='"+footerLinkText+"']/ancestor::div[@class='navFooterLinkCol navAccessibility']/div")).getText();

	}
}
