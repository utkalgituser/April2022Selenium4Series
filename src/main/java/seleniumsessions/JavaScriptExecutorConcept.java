package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {
	
	// browser --JS

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		System.out.println(js.executeScript("return document.title;", "").toString());
		driver.manage().window().maximize();
		
		js.executeScript("alert('hello java')", "");
		eutil=new ElementUtil(driver);
		Thread.sleep(2000);
		driver.quit();
	}

}
