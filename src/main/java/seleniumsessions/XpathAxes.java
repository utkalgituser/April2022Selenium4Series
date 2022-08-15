package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxes {

	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.espncricinfo.com/series/india-women-in-sri-lanka-2022-1319706/sri-lanka-women-vs-india-women-3rd-t20i-1319711/full-scorecard");
		driver.manage().window().maximize();
		eutil=new ElementUtil(driver);
		
		// xpath Axes
		
		// parent to child
		//form[@id='hs-login']//input[@id='username']
		//div[@class='private-form__input-wrapper']/input[@id='username']
		//div[@class='private-form__input-wrapper']/child::input[@id='username']
		//select[@id='Form_submitForm_Country']/option
		
		// child to parent
		// backward traversing in xpath
		//input[@id='username']/../../..
		//input[@id='username']/parent::div
		
		// child to grand parent
		//a[text()='Careers']/ancestor::div[@class='navFooterLinkCol navAccessibility'] 
		//a[text()='Careers']/ancestor::div[@class='navFooterLinkCol navAccessibility']//a[text()='About Us']
			
		//span[text()='Shafali Verma']/ancestor::td/following-sibling::td[@class='ds-min-w-max ds-text-right']
		Thread.sleep(2000);
		System.out.println(getWicketTakerName("Shafali Verma"));
		System.out.println(getWicketTakerName("Harmanpreet Kaur"));
		System.out.println(getScoreCard("Shafali Verma"));
		System.out.println(getScoreCard("Harmanpreet Kaur"));
		
		// for https://selectorshub.com/xpath-practice-page/
		//a[text()='Joe.Root']/preceding-sibling::input
		
		driver.quit();
	}
	
	public static String getWicketTakerName(String playerName) {
		return driver.findElement(By.xpath("//span[text()='"+playerName+"']/ancestor::td/following-sibling::td[@class='ds-min-w-max ds-text-right']")).getText();
	}
	
	public static List<String> getScoreCard(String playerName) {
		List<String> scoreCard = new ArrayList<>();
		List<WebElement> eles = driver.findElements(By.xpath("//span[text()='" + playerName
				+ "']/ancestor::td/following-sibling::td[@class='ds-min-w-max ds-text-right']"));
		for (WebElement e : eles) {
			scoreCard.add(e.getText());
		}
		return scoreCard;
	}
}
