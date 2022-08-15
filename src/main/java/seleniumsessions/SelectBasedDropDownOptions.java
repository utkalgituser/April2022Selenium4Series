package seleniumsessions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectBasedDropDownOptions {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		// dropdown - must have select dropdown tag
		// use select class from selenium

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		driver.manage().window().maximize();
		eutil = new ElementUtil(driver);
		
		By country=By.id("Form_submitForm_Country");
		By state=By.id("Form_submitForm_State");
		
		System.out.println(getDropDownCount(country));
		
		if(getDropDownCount(country)-1 == 231) {
			System.out.println("PASSED");
		}
		
		System.out.println(getDropDownValuesList(country));
		System.out.println(getDropDownValuesList(country).contains("India"));
		
		
		Select select=new Select(getElement(country));
		
		driver.quit();
	}
	
	public static int getDropDownCount(By locator) {
		Select select=new Select(getElement(locator));
		return select.getOptions().size();
	}
	
	public static List<String> getDropDownValuesList(By locator) {
		Select select=new Select(getElement(locator));
		List<String> optionsValList=new ArrayList<>();
		List<WebElement> optionsEleList = select.getOptions();
		for(WebElement e:optionsEleList) {
			String text=e.getText();
			optionsValList.add(text);
		}
		return optionsValList;
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
}
