package seleniumsessions;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	private WebDriver driver;

	/**
	 * This method is used to initialize the driver on the basis of given browser
	 * name
	 * 
	 * @param browserName
	 * @return this returns driver
	 */
	public WebDriver initDriver(String browserName) {
		System.out.println("browser name is : " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Enter correct browser name");
		}

		return driver;
	}

	// Try with switch case above code

	/**
	 * 
	 * @param url
	 */
	public void launchUrl(String url) {
		if (Objects.isNull(url)) {
			System.out.println("URL is null...");
			return;
		}
		if (url.indexOf("http") == -1) {
			System.out.println("URL is not having http...");
			return;
		}
		if (url.indexOf("https") == -1) {
			System.out.println("URL is not having https...");
			return;
		}
		driver.get(url);
	}

	// assignment, check for http or, https in url
	// assignment, check for url is blank
	// Custom exception that no browserexception

	/**
	 * 
	 * @return
	 */
	public String getPageTitle() {
		return driver.getCurrentUrl();
	}

	/**
	 * 
	 * @return
	 */
	public String getPageUrl() {
		return driver.getTitle();
	}

	/**
	 * 
	 * @return
	 */
	public String getPageSource() {
		return driver.getPageSource();
	}

	public boolean isInfoExistsInPageSource(String info) {
		return getPageSource().contains(info);
	}

	public boolean isUrlFractionExists(String urlFraction) {
		if (getPageUrl().contains(urlFraction)) {
			return true;
		}
		return false;
	}

	public void closeBrowser() {
		if (Objects.nonNull(driver)) {
			driver.close();
		}
	}

	public void quitBrowser() {
		if (Objects.nonNull(driver)) {
			driver.quit();
		}
	}
}
