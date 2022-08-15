package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GooglePage {
	static WebDriver driver = null;
	static ElementUtil eutil = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		eutil=new ElementUtil(driver);
		
		System.out.println(driver.getCurrentUrl());
		String textToSearch = "johny depp";
		By searchListxpath = By.xpath("//div[@role='presentation']//li");
		String searchListText = "movies";
		By serachBox = By.name("q");
		eutil.serach(serachBox, textToSearch, searchListxpath, searchListText);
		
		driver.get("https://www.google.com/");
		By googleOffered=By.id("SIvCob");
		System.out.println(eutil.doElementGetText(googleOffered));
		By footer=By.xpath("//div[@class='KxwPGc AghGtd']");
		System.out.println(eutil.doElementGetText(footer));
		driver.quit();
	}

}
